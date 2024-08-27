package io.github.jesusmoh;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

public class Main {

    public static void main(String[] args) {
        Source source = new Source("John", 30);

        JMapperAPI api = new JMapperAPI()
                .add(mappedClass(Destination.class)
                        .add(attribute("name").value("name"))
                        .add(attribute("age").value("age")));

        JMapper<Destination, Source> mapper = new JMapper<>(Destination.class, Source.class, api);
        Destination destination = mapper.getDestination(source);

        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
    }

    static class Source {
        private String name;
        private int age;

        public Source(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Source{name='" + name + "', age=" + age + "}";
        }
    }

    static class Destination {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Destination{name='" + name + "', age=" + age + "}";
        }
    }
}