#this is a powershell file which copies from github to node machine

Invoke-WebRequest -Uri https://github.com/rmondalDevOps/repo2/blob/f8390d6492e54b68250e2c345a8b5f30e16bfef5/install_links.sh -OutFile install_links_copy.sh
Write-Host "Your file is copied!"
