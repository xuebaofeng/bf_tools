paths = ["c:\\PortableApps\\PortableApps.com\\PortableAppsPlatform.exe",
		 "c:\\green\\syncthing\\syncthing.exe"]

s=""

for line in paths:
    s += "start  \"\" \"{0}\"\n".format(line)

f = open(r'C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp\startup.bat', 'w')
f.write(s)
f.close()