$app = Get-WmiObject -ComputerName MCSTEST63 -Class Win32_Product | Where-Object { 
    $_.Name -like "ArcGIS Workflow Manager Server*" 
}
$buildNumber = $app.Version 
$buildNumber 
