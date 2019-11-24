package com.lbchyx.owner;

import org.aeonbits.owner.Config;

@Config.HotReload
@Config.Sources({"classpath:ServerConfig.properties"})
public interface ServerConfig extends Config {
    @Key("server.http.port")
    int port();

    @Key("server.host.name")
    String hostname();

    @DefaultValue("42")
    int maxThreads();
}
