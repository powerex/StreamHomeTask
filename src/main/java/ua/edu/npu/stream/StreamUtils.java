package ua.edu.npu.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {

    public static String task01(List<String> nameList) {
        return IntStream.range(0, nameList.size())
                .boxed()
                .map(x -> x * 2 + 1 + ". " + nameList.get(x))
                .collect(Collectors.joining(", "));
        //.collect(Collectors.toList())
        //.toString();
    }

    public static List<String> task02(List<String> list) {
        return list.stream()
                .map(x -> x.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> task03(List<String> list) {
        String separator = ", ";
        return list.stream()
                .map(x -> Arrays.asList(x.split(separator)))
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }

    public static IntStream task04(long seed, long a, long c, long m) {
        return IntStream.iterate(Math.toIntExact(seed), x -> Math.toIntExact(((a * x + c) % m)));
    }

    public static <T>Stream<T> task05(Stream<T> first, Stream<T> second) {
        Iterator<T> i1 = first.iterator();
        Iterator<T> i2 = second.iterator();
        Stream<T> resultStream = Stream.empty();
        while (i1.hasNext() & i2.hasNext()){
            resultStream = Stream.concat(resultStream, Stream.of(i1.next(), i2.next()));
        }
        return resultStream;
    }
}
