package hachi.javaplayground.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@Getter
@Setter
public class Response {

    private String name;
    private int age;
}
