package cn.montaro.aria2.model;

import lombok.Data;

import java.util.List;

@Data
public class Aria2Version {
    private String version;
    private List<String> enabledFeatures;
}
