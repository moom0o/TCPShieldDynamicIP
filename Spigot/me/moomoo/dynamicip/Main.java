package me.moomoo.dynamicip;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Main extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();
    public String getIP() throws IOException {
        URL url = new URL("http://checkip.amazonaws.com/");
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public String changeIP(String ip) throws IOException {
        JSONObject data = new JSONObject();
        JSONObject child = new JSONObject();
        child.put("ID", String.valueOf(getConfig().getInt("ID")));
        child.put("Domain", getConfig().getString("Domain"));
        if(getConfig().getBoolean("Bungeecord")){
            child.put("Backend", ip + ":" + getConfig().getInt("BungeePort"));
        } else {
            child.put("Backend", ip + ":" + Bukkit.getPort());
        }
        data.put("data", child);
        data.put("action", "update");
        System.out.println(data);
        URL url = new URL("https://panel.tcpshield.com/ajax/servers");
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        httpConn.setDoOutput(true);
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type", "text/plain");
        httpConn.setRequestProperty("Cookie", "s=" + getConfig().getString("Token"));
        OutputStreamWriter wr= new OutputStreamWriter(httpConn.getOutputStream());
        wr.write(String.valueOf(data));
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("[ENABLED] moomoo's dynamic ip plugin");

        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        try {
            System.out.println("[TCPShieldDynamicIP] Current IP address: " + getIP());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(changeIP(getIP()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onDisable() {
        System.out.println("[DISABLED] moomoo's dynamic ip plugin");
    }
}
