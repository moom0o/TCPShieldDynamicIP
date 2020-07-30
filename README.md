# TCPShieldDynamicIP
A plugin to add to your minecraft server if you have a dynamic IP!

Made for some server owner friends

## Using bungeecord/waterfall?
Make sure to set bungeecord to true in the config and specify your bungeecord port.

## DESIGNED FOR 1.12.2!
Don't come crying if it doesn't work on newer versions! (It should.)

## How to get TCPShield data?

Head to https://panel.tcpshield.com

Go to servers

Press CTRL + Shift + I

Click network

Now as its recording the network requests, change the ip as you would normally.

You should see a request, click it 
<br>
<img src="https://i.imgur.com/DEdFhAV.png">
<br>

Scroll down until you find cookie **MAKE SURE TO ONLY SELECT EVERYTHING AFTER s=**
<br>
<img src="https://i.imgur.com/2eXjZzq.png">
<br>
paste that into the token part of the config.

Now scroll down all the way until you see the form data.
<br>
<img src="https://i.imgur.com/EO2oRZN.png">
<br>
copy your id and paste into the ID part of the config.

Now you are done with the panel part! Last thing is change your domain in the config to the exact domain in your tcpshield panel.

Now you can test it! Change the ip in the panel to something that is not yours and restart the server. After its done starting the ip in tcpshield should be the same as your current ip address!
