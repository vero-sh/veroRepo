package gestionale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

public class EmployeeManagerSwing extends JFrame {

    private final EmployeeDAO dao = new EmployeeDAO();
    private final DefaultTableModel model;
    private final JTable table;

    public EmployeeManagerSwing() {
        super("✨ Gestionale Dipendenti ✨");
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("OptionPane.yesButtonText", "Sì");
        UIManager.put("OptionPane.noButtonText", "No");

        // --- Table ---
        model = new DefaultTableModel(new Object[]{"ID", "Nome", "Cognome", "Email", "Assunto il", "Stipendio (€)"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        table.setRowHeight(24);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        add(new JScrollPane(table), BorderLayout.CENTER);

        // --- Buttons ---
        JButton addBtn = createButton("➕ Aggiungi");
        JButton editBtn = createButton("✏️ Modifica");
        JButton delBtn = createButton("🗑️ Elimina");

        addBtn.addActionListener(e -> openForm(null));
        editBtn.addActionListener(e -> editSelected());
        delBtn.addActionListener(e -> deleteSelected());

        JPanel south = new JPanel();
        south.setBorder(new EmptyBorder(10, 10, 10, 10));
        south.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        south.add(addBtn);
        south.add(editBtn);
        south.add(delBtn);
        add(south, BorderLayout.SOUTH);

        // --- Frame settings ---
        setSize(850, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        refreshTable();
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(50, 150, 255));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(140, 36));
        return btn;
    }

    private void refreshTable() {
        model.setRowCount(0);
        try {
            List<Employee> all = dao.findAll();
            for (Employee e : all) {
                model.addRow(new Object[]{e.getId(), e.getName(), e.getSurname(), e.getEmail(), e.getHireDate(), e.getSalary()});
            }
        } catch (SQLException ex) {
            showError(ex);
        }
    }

    private void editSelected() {
        int sel = table.getSelectedRow();
        if (sel == -1) return;
        int id = (int) model.getValueAt(sel, 0);
        try {
            List<Employee> all = dao.findAll();
            for (Employee emp : all) {
                if (emp.getId() == id) {
                    openForm(emp);
                    break;
                }
            }
        } catch (SQLException ex) {
            showError(ex);
        }
    }

    private void deleteSelected() {
        int sel = table.getSelectedRow();
        if (sel == -1) return;
        int id = (int) model.getValueAt(sel, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Eliminare il dipendente selezionato?", "Conferma", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                dao.delete(id);
                refreshTable();
            } catch (SQLException ex) {
                showError(ex);
            }
        }
    }

    private void openForm(Employee emp) {
        boolean isEdit = emp != null;

        JDialog dialog = new JDialog(this, isEdit ? "Modifica Dipendente" : "Nuovo Dipendente", true);
        dialog.setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setBorder(new EmptyBorder(15, 20, 10, 20));
        JTextField nomeField = new JTextField();
        JTextField cognomeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField dateField = new JTextField("YYYY-MM-DD");
        JTextField salaryField = new JTextField();

        form.add(new JLabel("Nome:")); form.add(nomeField);
        form.add(new JLabel("Cognome:")); form.add(cognomeField);
        form.add(new JLabel("Email:")); form.add(emailField);
        form.add(new JLabel("Data assunzione:")); form.add(dateField);
        form.add(new JLabel("Stipendio (€):")); form.add(salaryField);

        if (isEdit) {
            nomeField.setText(emp.getName());
            cognomeField.setText(emp.getSurname());
            emailField.setText(emp.getEmail());
            dateField.setText(emp.getHireDate().toString());
            salaryField.setText(String.valueOf(emp.getSalary()));
        }

        JButton saveBtn = createButton("Salva");
        JButton cancelBtn = createButton("Annulla");

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.setBorder(new EmptyBorder(0, 10, 10, 10));
        buttons.add(saveBtn);
        buttons.add(cancelBtn);

        saveBtn.addActionListener(e -> {
            try {
                String nome = nomeField.getText().trim();
                String cognome = cognomeField.getText().trim();
                String email = emailField.getText().trim();
                LocalDate ld = LocalDate.parse(dateField.getText().trim());
                double salary = Double.parseDouble(salaryField.getText().trim());

                Employee toSave = isEdit ? emp : new Employee();
                toSave.setName(nome);
                toSave.setSurname(cognome);
                toSave.setEmail(email);
                toSave.setHireDate(Date.valueOf(ld));
                toSave.setSalary(salary);

                if (isEdit) dao.update(toSave); else dao.create(toSave);
                refreshTable();
                dialog.dispose();
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(dialog, "Formato data non valido (use YYYY-MM-DD)", "Errore", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Stipendio non valido", "Errore", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                showError(ex);
            }
        });

        cancelBtn.addActionListener(e -> dialog.dispose());

        dialog.add(form, BorderLayout.CENTER);
        dialog.add(buttons, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showError(Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
    }

}