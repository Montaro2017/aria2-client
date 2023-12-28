package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Protocol {

    WS("ws"),
    WSS("wss"),
    HTTP("http"),
    HTTPS("https");

    private final String value;

}
