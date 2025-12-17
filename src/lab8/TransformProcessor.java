package lab8;

import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class TransformProcessor {

    public List<String> process(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
