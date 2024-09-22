package ru.vertenberger.FirstJavaSpringBootApp.tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    private List<String> stringList = new ArrayList<>();
    private Map<Integer, String> stringMap = new HashMap<>();

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        if (stringList.isEmpty()) {
            stringList = new ArrayList<>();
        }
        stringList.add(s);
        return "Добавление значения " + s + " в ArrayList";
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return stringList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        if (stringMap.isEmpty()) {
            stringMap = new HashMap<>();
        }
        int key = stringMap.size() + 1;
        stringMap.put(key, s);
        return "Добавление значения " + s + " в HashMap с ключом " + key;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return stringMap;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int arrayListSize = stringList.size();
        int hashMapSize = stringMap.size();

        return "Количество значений в ArrayList: " + arrayListSize
                + "\nКоличество значений в HashMap: " + hashMapSize;
    }
}
