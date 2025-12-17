package lab8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DataManager {

    private List<String> data = new ArrayList<>();
    private final List<Object> processors = new ArrayList<>();

    private final ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void registerDataProcessor(Object processor) {
        if (!processor.getClass().isAnnotationPresent(DataProcessor.class)) {
            throw new IllegalArgumentException(
                    "Обработчик должен быть помечен аннотацией @DataProcessor"
            );
        }
        processors.add(processor);
    }

    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Path.of(source));
    }

    public void processData() throws InterruptedException {
        List<Callable<Void>> tasks = processors.stream()
                .map(processor -> (Callable<Void>) () -> {
                    Method method = processor.getClass().getMethod("process", List.class);
                    synchronized (this) {
                        data = (List<String>) method.invoke(processor, data);
                    }
                    return null;
                })
                .collect(Collectors.toList());

        executor.invokeAll(tasks);
        executor.shutdown();
    }

    public void saveData(String destination) throws IOException {
        Files.write(Path.of(destination), data);
    }
}
