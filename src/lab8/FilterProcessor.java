package lab8;

import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class FilterProcessor {

    public List<String> process(List<String> data) {
        return data.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
    }
}

