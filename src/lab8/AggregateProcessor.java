package lab8;

import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class AggregateProcessor {

    public List<String> process(List<String> data) {
        return data.stream()
                .map(s -> s + " (" + s.length() + ")")
                .collect(Collectors.toList());
    }
}
