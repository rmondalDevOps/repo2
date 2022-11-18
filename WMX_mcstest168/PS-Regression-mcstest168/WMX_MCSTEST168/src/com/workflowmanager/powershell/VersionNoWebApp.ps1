$app = Get-WmiObject -ComputerName MCSTEST62 -Class Win32_Product | Where-Object { 
    $_.Name -like "ArcGIS Workflow Manager*" 
}
$buildNumber = $app.Version 
$buildNumber 