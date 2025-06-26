# Verifica privilegi amministrativi
if (-not ([Security.Principal.WindowsPrincipal][Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)) {
    Start-Process powershell.exe "-NoProfile -ExecutionPolicy Bypass -File `"$PSCommandPath`"" -Verb RunAs
    exit
}
echo "FIVEM VERSION THAT DOESN'T STOP PROCESSES THAT ARE IMORTANT FOR SS"

function Apply-RegistryTweaks {
    param($tweaks)

    foreach ($tweak in $tweaks) {
        try {
            if (-not (Test-Path $tweak.Path)) {
                New-Item -Path $tweak.Path -Force -ErrorAction Stop | Out-Null
            }
            Set-ItemProperty -Path $tweak.Path -Name $tweak.Name -Value $tweak.Value -Type $tweak.Type -ErrorAction Stop
            Write-Host "  [REG] $($tweak.Path)\$($tweak.Name) = $($tweak.Value)" -ForegroundColor Green
        }
        catch {
            Write-Host "  [ERRORE] Registro: $_" -ForegroundColor Red
        }
    }
}

function Apply-ServiceTweaks {
    param($services)

    foreach ($svc in $services) {
        try {
            $serviceList = if ($svc.Name -like "*`**") {
                Get-Service | Where-Object Name -like $svc.Name
            } else {
                Get-Service -Name $svc.Name -ErrorAction Stop
            }
            
            foreach ($service in $serviceList) {
                Set-Service -Name $service.Name -StartupType $svc.StartupType -ErrorAction Stop
                Write-Host "  [SVC] $($service.Name) impostato a $($svc.StartupType)" -ForegroundColor Green
            }
        }
        catch {
            Write-Host "  [ERRORE] Servizio $($svc.Name): $_" -ForegroundColor Red
        }
    }
}

function Invoke-Scripts {
    param($scripts)

    foreach ($cmd in $scripts) {
        try {
            Invoke-Expression $cmd | Out-Null
            Write-Host "  [CMD] $cmd eseguito" -ForegroundColor Green
        }
        catch {
            Write-Host "  [ERRORE] Comando: $_" -ForegroundColor Red
        }
    }
}

# Disabilita Activity History
Write-Host "`nDisabilitazione Activity History..." -ForegroundColor Cyan
$ahTweaks = @(
    @{Path="HKLM:\SOFTWARE\Policies\Microsoft\Windows\System"; Name="EnableActivityFeed"; Type="DWord"; Value=0},
    @{Path="HKLM:\SOFTWARE\Policies\Microsoft\Windows\System"; Name="PublishUserActivities"; Type="DWord"; Value=0},
    @{Path="HKLM:\SOFTWARE\Policies\Microsoft\Windows\System"; Name="UploadUserActivities"; Type="DWord"; Value=0}
)
Apply-RegistryTweaks $ahTweaks
Start-Sleep -Seconds 2,
# Disabilita Hibernation
Write-Host "`nDisabilitazione Hibernation..." -ForegroundColor Cyan
$hiberTweaks = @(
    @{Path="HKLM:\System\CurrentControlSet\Control\Session Manager\Power"; Name="HibernateEnabled"; Type="DWord"; Value=0},
    @{Path="HKLM:\SOFTWARE\Microsoft\Windows\CurrentVersion\Explorer\FlyoutMenuSettings"; Name="ShowHibernateOption"; Type="DWord"; Value=0}
)
Apply-RegistryTweaks $hiberTweaks
Invoke-Scripts @("powercfg.exe /hibernate off")


# Disabilita Homegroup
Write-Host "`nDisabilitazione Homegroup..." -ForegroundColor Cyan
$homeServices = @(
    @{Name="HomeGroupListener"; StartupType="Manual"},
    @{Name="HomeGroupProvider"; StartupType="Manual"}
)
Apply-ServiceTweaks $homeServices

# Disabilita Location Tracking
Write-Host "`nDisabilitazione Location Tracking..." -ForegroundColor Cyan
$locTweaks = @(
    @{Path="HKLM:\SOFTWARE\Microsoft\Windows\CurrentVersion\CapabilityAccessManager\ConsentStore\location"; Name="Value"; Type="String"; Value="Deny"},
    @{Path="HKLM:\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Sensor\Overrides\{BFA794E4-F964-4FDB-90F6-51056BFE4B44}"; Name="SensorPermissionState"; Type="DWord"; Value=0},
    @{Path="HKLM:\SYSTEM\CurrentControlSet\Services\lfsvc\Service\Configuration"; Name="Status"; Type="DWord"; Value=0},
    @{Path="HKLM:\SYSTEM\Maps"; Name="AutoUpdateEnabled"; Type="DWord"; Value=0}
)
Apply-RegistryTweaks $locTweaks

# Modifica servizi di sistema
Write-Host "`nModifica servizi di sistema..." -ForegroundColor Cyan
$servicesList = @(
    @{Name="AJRouter"; StartupType="Disabled"},
    @{Name="ALG"; StartupType="Manual"},
    @{Name="AppIDSvc"; StartupType="Manual"},
    @{Name="AppMgmt"; StartupType="Manual"},
    @{Name="AppReadiness"; StartupType="Manual"},
    @{Name="AppVClient"; StartupType="Disabled"},
    @{Name="AppXSvc"; StartupType="Manual"},
    @{Name="Appinfo"; StartupType="Manual"},
    @{Name="AssignedAccessManagerSvc"; StartupType="Disabled"},
    @{Name="AudioEndpointBuilder"; StartupType="Automatic"},
    @{Name="AudioSrv"; StartupType="Automatic"},
    @{Name="Audiosrv"; StartupType="Automatic"},
    @{Name="AxInstSV"; StartupType="Manual"},
    @{Name="BDESVC"; StartupType="Manual"},
    @{Name="BFE"; StartupType="Automatic"},
    @{Name="BITS"; StartupType="AutomaticDelayedStart"},
    @{Name="BTAGService"; StartupType="Manual"},
    @{Name="BcastDVRUserService_*"; StartupType="Manual"},
    @{Name="BluetoothUserService_*"; StartupType="Manual"},
    @{Name="BrokerInfrastructure"; StartupType="Automatic"},
    @{Name="Browser"; StartupType="Manual"},
    @{Name="BthAvctpSvc"; StartupType="Automatic"},
    @{Name="BthHFSrv"; StartupType="Automatic"},
    @{Name="CDPSvc"; StartupType="Manual"},
    @{Name="CDPUserSvc_*"; StartupType="Automatic"},
    @{Name="COMSysApp"; StartupType="Manual"},
    @{Name="CaptureService_*"; StartupType="Manual"},
    @{Name="CertPropSvc"; StartupType="Manual"},
    @{Name="ClipSVC"; StartupType="Manual"},
    @{Name="ConsentUxUserSvc_*"; StartupType="Manual"},
    @{Name="CoreMessagingRegistrar"; StartupType="Automatic"},
    @{Name="CredentialEnrollmentManagerUserSvc_*"; StartupType="Manual"},
    @{Name="CryptSvc"; StartupType="Automatic"},
    @{Name="CscService"; StartupType="Manual"},
    @{Name="DPS"; StartupType="Automatic"},
    @{Name="DcomLaunch"; StartupType="Automatic"},
    @{Name="DcpSvc"; StartupType="Manual"},
    @{Name="DevQueryBroker"; StartupType="Manual"},
    @{Name="DeviceAssociationBrokerSvc_*"; StartupType="Manual"},
    @{Name="DeviceAssociationService"; StartupType="Manual"},
    @{Name="DeviceInstall"; StartupType="Manual"},
    @{Name="DevicePickerUserSvc_*"; StartupType="Manual"},
    @{Name="DevicesFlowUserSvc_*"; StartupType="Manual"},
    @{Name="Dhcp"; StartupType="Automatic"},
    @{Name="DiagTrack"; StartupType="Automatic"},
    @{Name="DialogBlockingService"; StartupType="Disabled"},
    @{Name="DispBrokerDesktopSvc"; StartupType="Automatic"},
    @{Name="DisplayEnhancementService"; StartupType="Manual"},
    @{Name="DmEnrollmentSvc"; StartupType="Manual"},
    @{Name="Dnscache"; StartupType="Automatic"},
    @{Name="EFS"; StartupType="Manual"},
    @{Name="EapHost"; StartupType="Manual"},
    @{Name="EntAppSvc"; StartupType="Manual"},
    @{Name="EventLog"; StartupType="Automatic"},
    @{Name="EventSystem"; StartupType="Automatic"},
    @{Name="FDResPub"; StartupType="Manual"},
    @{Name="Fax"; StartupType="Manual"},
    @{Name="FontCache"; StartupType="Automatic"},
    @{Name="FrameServer"; StartupType="Manual"},
    @{Name="FrameServerMonitor"; StartupType="Manual"},
    @{Name="GraphicsPerfSvc"; StartupType="Manual"},
    @{Name="HomeGroupListener"; StartupType="Manual"},
    @{Name="HomeGroupProvider"; StartupType="Manual"},
    @{Name="HvHost"; StartupType="Manual"},
    @{Name="IEEtwCollectorService"; StartupType="Manual"},
    @{Name="IKEEXT"; StartupType="Manual"},
    @{Name="InstallService"; StartupType="Manual"},
    @{Name="InventorySvc"; StartupType="Manual"},
    @{Name="IpxlatCfgSvc"; StartupType="Manual"},
    @{Name="KeyIso"; StartupType="Automatic"},
    @{Name="KtmRm"; StartupType="Manual"},
    @{Name="LSM"; StartupType="Automatic"},
    @{Name="LanmanServer"; StartupType="Automatic"},
    @{Name="LanmanWorkstation"; StartupType="Automatic"},
    @{Name="LicenseManager"; StartupType="Manual"},
    @{Name="LxpSvc"; StartupType="Manual"},
    @{Name="MSDTC"; StartupType="Manual"},
    @{Name="MSiSCSI"; StartupType="Manual"},
    @{Name="MapsBroker"; StartupType="AutomaticDelayedStart"},
    @{Name="McpManagementService"; StartupType="Manual"},
    @{Name="MessagingService_*"; StartupType="Manual"},
    @{Name="MicrosoftEdgeElevationService"; StartupType="Manual"},
    @{Name="MixedRealityOpenXRSvc"; StartupType="Manual"},
    @{Name="MpsSvc"; StartupType="Automatic"},
    @{Name="MsKeyboardFilter"; StartupType="Manual"},
    @{Name="NPSMSvc_*"; StartupType="Manual"},
    @{Name="NaturalAuthentication"; StartupType="Manual"},
    @{Name="NcaSvc"; StartupType="Manual"},
    @{Name="NcbService"; StartupType="Manual"},
    @{Name="NcdAutoSetup"; StartupType="Manual"},
    @{Name="NetSetupSvc"; StartupType="Manual"},
    @{Name="NetTcpPortSharing"; StartupType="Disabled"},
    @{Name="Netlogon"; StartupType="Automatic"},
    @{Name="Netman"; StartupType="Manual"},
    @{Name="NgcCtnrSvc"; StartupType="Manual"},
    @{Name="NgcSvc"; StartupType="Manual"},
    @{Name="NlaSvc"; StartupType="Manual"},
    @{Name="OneSyncSvc_*"; StartupType="Automatic"},
    @{Name="P9RdrService_*"; StartupType="Manual"},
    @{Name="PNRPAutoReg"; StartupType="Manual"},
    @{Name="PNRPsvc"; StartupType="Manual"},
    @{Name="PcaSvc"; StartupType="Automatic"},
    @{Name="PeerDistSvc"; StartupType="Manual"},
    @{Name="PenService_*"; StartupType="Manual"},
    @{Name="PerfHost"; StartupType="Manual"},
    @{Name="PhoneSvc"; StartupType="Manual"},
    @{Name="PimIndexMaintenanceSvc_*"; StartupType="Manual"},
    @{Name="PlugPlay"; StartupType="Manual"},
    @{Name="PolicyAgent"; StartupType="Manual"},
    @{Name="Power"; StartupType="Automatic"},
    @{Name="PrintNotify"; StartupType="Manual"},
    @{Name="PrintWorkflowUserSvc_*"; StartupType="Manual"},
    @{Name="ProfSvc"; StartupType="Automatic"},
    @{Name="PushToInstall"; StartupType="Manual"},
    @{Name="QWAVE"; StartupType="Manual"},
    @{Name="RasAuto"; StartupType="Manual"},
    @{Name="RasMan"; StartupType="Manual"},
    @{Name="RemoteAccess"; StartupType="Disabled"},
    @{Name="RemoteRegistry"; StartupType="Disabled"},
    @{Name="RetailDemo"; StartupType="Manual"},
    @{Name="RmSvc"; StartupType="Manual"},
    @{Name="RpcEptMapper"; StartupType="Automatic"},
    @{Name="RpcLocator"; StartupType="Manual"},
    @{Name="RpcSs"; StartupType="Automatic"},
    @{Name="SCPolicySvc"; StartupType="Manual"},
    @{Name="SCardSvr"; StartupType="Manual"},
    @{Name="SDRSVC"; StartupType="Manual"},
    @{Name="SEMgrSvc"; StartupType="Manual"},
    @{Name="SENS"; StartupType="Automatic"},
    @{Name="SNMPTRAP"; StartupType="Manual"},
    @{Name="SNMPTrap"; StartupType="Manual"},
    @{Name="SSDPSRV"; StartupType="Manual"},
    @{Name="SamSs"; StartupType="Automatic"},
    @{Name="ScDeviceEnum"; StartupType="Manual"},
    @{Name="Schedule"; StartupType="Automatic"},
    @{Name="SecurityHealthService"; StartupType="Manual"},
    @{Name="Sense"; StartupType="Manual"},
    @{Name="SensorDataService"; StartupType="Manual"},
    @{Name="SensorService"; StartupType="Manual"},
    @{Name="SensrSvc"; StartupType="Manual"},
    @{Name="SessionEnv"; StartupType="Manual"},
    @{Name="SharedAccess"; StartupType="Manual"},
    @{Name="SharedRealitySvc"; StartupType="Manual"},
    @{Name="ShellHWDetection"; StartupType="Automatic"},
    @{Name="SmsRouter"; StartupType="Manual"},
    @{Name="Spooler"; StartupType="Automatic"},
    @{Name="SstpSvc"; StartupType="Manual"},
    @{Name="StiSvc"; StartupType="Manual"},
    @{Name="StorSvc"; StartupType="Manual"},
    @{Name="SysMain"; StartupType="Automatic"},
    @{Name="SystemEventsBroker"; StartupType="Automatic"},
    @{Name="TabletInputService"; StartupType="Manual"},
    @{Name="TapiSrv"; StartupType="Manual"},
    @{Name="TermService"; StartupType="Automatic"},
    @{Name="Themes"; StartupType="Automatic"},
    @{Name="TieringEngineService"; StartupType="Manual"},
    @{Name="TimeBroker"; StartupType="Manual"},
    @{Name="TimeBrokerSvc"; StartupType="Manual"},
    @{Name="TokenBroker"; StartupType="Manual"},
    @{Name="TrkWks"; StartupType="Automatic"},
    @{Name="TroubleshootingSvc"; StartupType="Manual"},
    @{Name="TrustedInstaller"; StartupType="Manual"},
    @{Name="UI0Detect"; StartupType="Manual"},
    @{Name="UdkUserSvc_*"; StartupType="Manual"},
    @{Name="UevAgentService"; StartupType="Disabled"},
    @{Name="UmRdpService"; StartupType="Manual"},
    @{Name="UnistoreSvc_*"; StartupType="Manual"},
    @{Name="UserDataSvc_*"; StartupType="Manual"},
    @{Name="UserManager"; StartupType="Automatic"},
    @{Name="UsoSvc"; StartupType="Manual"},
    @{Name="VGAuthService"; StartupType="Automatic"},
    @{Name="VMTools"; StartupType="Automatic"},
    @{Name="VSS"; StartupType="Manual"},
    @{Name="VacSvc"; StartupType="Manual"},
    @{Name="VaultSvc"; StartupType="Automatic"},
    @{Name="W32Time"; StartupType="Manual"},
    @{Name="WEPHOSTSVC"; StartupType="Manual"},
    @{Name="WFDSConMgrSvc"; StartupType="Manual"},
    @{Name="WMPNetworkSvc"; StartupType="Manual"},
    @{Name="WManSvc"; StartupType="Manual"},
    @{Name="WPDBusEnum"; StartupType="Manual"},
    @{Name="WSService"; StartupType="Manual"},
    @{Name="WSearch"; StartupType="AutomaticDelayedStart"},
    @{Name="WaaSMedicSvc"; StartupType="Manual"},
    @{Name="WalletService"; StartupType="Manual"},
    @{Name="WarpJITSvc"; StartupType="Manual"},
    @{Name="WbioSrvc"; StartupType="Manual"},
    @{Name="Wcmsvc"; StartupType="Automatic"},
    @{Name="WcsPlugInService"; StartupType="Manual"},
    @{Name="WdNisSvc"; StartupType="Manual"},
    @{Name="WdiServiceHost"; StartupType="Manual"},
    @{Name="WdiSystemHost"; StartupType="Manual"},
    @{Name="WebClient"; StartupType="Manual"},
    @{Name="Wecsvc"; StartupType="Manual"},
    @{Name="WerSvc"; StartupType="Manual"},
    @{Name="WiaRpc"; StartupType="Manual"},
    @{Name="WinDefend"; StartupType="Automatic"},
    @{Name="WinHttpAutoProxySvc"; StartupType="Manual"},
    @{Name="WinRM"; StartupType="Manual"},
    @{Name="Winmgmt"; StartupType="Automatic"},
    @{Name="WlanSvc"; StartupType="Automatic"},
    @{Name="WpcMonSvc"; StartupType="Manual"},
    @{Name="WpnService"; StartupType="Manual"},
    @{Name="WpnUserService_*"; StartupType="Automatic"},
    @{Name="XblAuthManager"; StartupType="Manual"},
    @{Name="XblGameSave"; StartupType="Manual"},
    @{Name="XboxGipSvc"; StartupType="Manual"},
    @{Name="XboxNetApiSvc"; StartupType="Manual"},
    @{Name="autotimesvc"; StartupType="Manual"},
    @{Name="bthserv"; StartupType="Manual"},
    @{Name="camsvc"; StartupType="Manual"},
    @{Name="cbdhsvc_*"; StartupType="Manual"},
    @{Name="cloudidsvc"; StartupType="Manual"},
    @{Name="dcsvc"; StartupType="Manual"},
    @{Name="defragsvc"; StartupType="Manual"},
    @{Name="diagnosticshub.standardcollector.service"; StartupType="Manual"},
    @{Name="diagsvc"; StartupType="Manual"},
    @{Name="dmwappushservice"; StartupType="Manual"},
    @{Name="dot3svc"; StartupType="Manual"},
    @{Name="edgeupdate"; StartupType="Manual"},
    @{Name="edgeupdatem"; StartupType="Manual"},
    @{Name="embeddedmode"; StartupType="Manual"},
    @{Name="fdPHost"; StartupType="Manual"},
    @{Name="fhsvc"; StartupType="Manual"},
    @{Name="gpsvc"; StartupType="Automatic"},
    @{Name="hidserv"; StartupType="Manual"},
    @{Name="icssvc"; StartupType="Manual"},
    @{Name="iphlpsvc"; StartupType="Automatic"},
    @{Name="lfsvc"; StartupType="Manual"},
    @{Name="lltdsvc"; StartupType="Manual"},
    @{Name="lmhosts"; StartupType="Manual"},
    @{Name="mpssvc"; StartupType="Automatic"},
    @{Name="msiserver"; StartupType="Manual"},
    @{Name="netprofm"; StartupType="Manual"},
    @{Name="nsi"; StartupType="Automatic"},
    @{Name="p2pimsvc"; StartupType="Manual"},
    @{Name="p2psvc"; StartupType="Manual"},
    @{Name="perceptionsimulation"; StartupType="Manual"},
    @{Name="pla"; StartupType="Manual"},
    @{Name="seclogon"; StartupType="Manual"},
    @{Name="shpamsvc"; StartupType="Disabled"},
    @{Name="smphost"; StartupType="Manual"},
    @{Name="spectrum"; StartupType="Manual"},
    @{Name="sppsvc"; StartupType="AutomaticDelayedStart"},
    @{Name="ssh-agent"; StartupType="Disabled"},
    @{Name="svsvc"; StartupType="Manual"},
    @{Name="swprv"; StartupType="Manual"},
    @{Name="tiledatamodelsvc"; StartupType="Automatic"},
    @{Name="tzautoupdate"; StartupType="Disabled"},
    @{Name="uhssvc"; StartupType="Disabled"},
    @{Name="upnphost"; StartupType="Manual"},
    @{Name="vds"; StartupType="Manual"},
    @{Name="vm3dservice"; StartupType="Manual"},
    @{Name="vmicguestinterface"; StartupType="Manual"},
    @{Name="vmicheartbeat"; StartupType="Manual"},
    @{Name="vmickvpexchange"; StartupType="Manual"},
    @{Name="vmicrdv"; StartupType="Manual"},
    @{Name="vmicshutdown"; StartupType="Manual"},
    @{Name="vmictimesync"; StartupType="Manual"},
    @{Name="vmicvmsession"; StartupType="Manual"},
    @{Name="vmicvss"; StartupType="Manual"},
    @{Name="vmvss"; StartupType="Manual"},
    @{Name="wbengine"; StartupType="Manual"},
    @{Name="wcncsvc"; StartupType="Manual"},
    @{Name="webthreatdefsvc"; StartupType="Manual"},
    @{Name="webthreatdefusersvc_*"; StartupType="Automatic"},
    @{Name="wercplsupport"; StartupType="Manual"},
    @{Name="wisvc"; StartupType="Manual"},
    @{Name="wlidsvc"; StartupType="Manual"},
    @{Name="wlpasvc"; StartupType="Manual"},
    @{Name="wmiApSrv"; StartupType="Manual"},
    @{Name="workfolderssvc"; StartupType="Manual"},
    @{Name="wscsvc"; StartupType="AutomaticDelayedStart"},
    @{Name="wuauserv"; StartupType="Manual"},
    @{Name="wudfsvc"; StartupType="Manual"}
)
Apply-ServiceTweaks $servicesList

# Disabilita Cortana
Write-Host "`nDisabilitazione Cortana..." -ForegroundColor Cyan
Write-Host "`nTutte le modifiche sono state applicate con successo!" -ForegroundColor Green
Write-Host "Si consiglia un riavvio del sistema per completare le operazioni." -ForegroundColor Yellow