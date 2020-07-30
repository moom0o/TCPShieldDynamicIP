# TCPShieldDynamicIP
A plugin to add to your minecraft server if you have a dynamic IP!

Made for some server owner friends

**Currently spigot-paper only because waterfall is being a piece of shit and not working in intellij.**

## DESIGNED FOR 1.12.2!
Don't come crying if it doesn't work on newer versions! (It should.)

## How to get TCPShield data?

Head to https://panel.tcpshield.com

Go to servers

Press CTRL + Shift + I

Click network

Now as its recording the network requests, change the ip as you would normally.

You should see a request, click it 
<img src="https://i.imgur.com/DEdFhAV.png">


Scroll down until you find cookie **MAKE SURE TO ONLY SELECT EVERYTHING AFTER s=**
<img src="https://i.imgur.com/2eXjZzq.png">
paste that into the token part of the config.

Now scroll down all the way until you see the form data.
<img src="https://i.imgur.com/EO2oRZN.png">
copy your id and paste into the ID part of the config.

Now you are done with the panel part! Last thing is change your domain in the config to the exact domain in your tcpshield panel.

Now you can test it! Change the ip in the panel to something that is not yours and restart the server. After its done starting the ip in tcpshield should be the same as your current ip address!
