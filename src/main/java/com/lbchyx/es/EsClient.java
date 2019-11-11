package com.lbchyx.es;


import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class EsClient {
    private TransportClient client ;
    private static final String _INDEX = "mycompany";
    private static final String _TYPE = "employee";

    @Before
    public void setUp() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }

    @After
    public void query(){
        client.close();
    }
    //从ES中查询数据
    @Test
    public void get() throws UnknownHostException {
        //get方式数据查询 ,参数为Index,type和id
        GetResponse response = client.prepareGet(_INDEX,_TYPE,"1").get();
        System.out.println(response.getSourceAsString());
    }

    //insert
    @Test
    public void insert() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("game");
        list.add("computer");
        XContentBuilder xContentBuilder = jsonBuilder().startObject()
                .field("first_name", "binchao")
                .field("last_name", "li")
                .field("age", "28")
                .field("about", "i like to play basketball")
                .field("interests", list)
                .endObject();
        System.out.println(xContentBuilder.string());
        IndexResponse indexResponse = client.prepareIndex(_INDEX, _TYPE, "" + 6)
                .setSource(xContentBuilder).get();
        String s = indexResponse.toString();
        System.out.println(s);
    }

    @Test
    public void query_simple(){

        SearchResponse searchResponse = client.prepareSearch().execute().actionGet();
        System.out.println(searchResponse);
    }

    @Test
    public void query_hard(){


    }

    @Test
    public void delete(){

    }

    @Test
    public void update(){

    }

}
