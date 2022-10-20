#creating a file
New-Item -Path /root/hello_powershell.txt -ItemType File
Set-Content /root/hello_powershell.txt "Hi, this is a file made from linux powershell file"
Get-Content "/root/hello_powershell.txt"
