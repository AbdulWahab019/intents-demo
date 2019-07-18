package com.example.intent;

import android.content.Intent;
import android.net.Uri;

class ImplicitAct {

    Intent OpenMaps(String lat, String lon){
        String uriBegin = "geo:" + lat + "," + lon;
        String query = lat + "," + lon + "(" + lat+","+lon + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uri = Uri.parse(uriString);
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        return mapIntent;
    }
}
