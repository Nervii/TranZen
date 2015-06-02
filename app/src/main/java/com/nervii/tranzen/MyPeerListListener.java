package com.nervii.tranzen;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;

/**
 * Created by bgreen on 6/2/2015.
 */
public class MyPeerListListener implements WifiP2pManager.PeerListListener {

    private MainActivity myActivity;
    public MyPeerListListener(MainActivity activity) {
        this.myActivity = activity;
    }
    public void onPeersAvailable(WifiP2pDeviceList deviceList) {
        ListView buddyList = (ListView) myActivity.findViewById(R.id.buddyList);
        Collection<WifiP2pDevice> list = deviceList.getDeviceList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(myActivity, android.R.layout.simple_list_item_1,
                R.id.buddyList, list.toArray(new String[list.size()]));
        buddyList.setAdapter(adapter);
    }
}
