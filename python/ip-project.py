#ipinfo skal installeres igennem pip og programmet køres igennem pyhton 3

import ipinfo, sys, webbrowser

access_token = '$TOKEN'
# Tjekker om der er et argument sendt med (IP-adresse)
if len(sys.argv) == 1:
    details = ipinfo.getHandler(access_token).getDetails()
else:
    details = ipinfo.getHandler(access_token).getDetails(sys.argv[1])

ip = 'http://maps.google.com/?ie=UTF8&hq=&ll=' + details.loc + '&z=13'

#Printer informationen
print('IP-info')
print('IP-adresse:\t\t' + details.ip)
print('Fysisk lokation:\t' + details.postal + ' ' + details.city)
print('Link:\t\t\t' + ip)

print("\nVil du åbne Google Maps Link? Y/n")
choice = input()

if choice == 'Y':
    webbrowser.open(ip)
