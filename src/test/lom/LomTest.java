package test.lom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

class Dog {
    private String name;
    private int age;

}

public class LomTest {
    public static void main(String[] args) {
        Dog d = new Dog("강아지", 10);
        d.setName("이름변경");
        System.out.println(d.getName());
    }
}
