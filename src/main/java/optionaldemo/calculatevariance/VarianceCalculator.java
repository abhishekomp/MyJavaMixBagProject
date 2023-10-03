package optionaldemo.calculatevariance;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sca820 on 09 nov., 2022
 * https://medium.com/@satish.manit/error-handling-with-optional-in-java-bb6db8f2cedc
 */
public class VarianceCalculator {

    public Double calculateVariance(Collection<Double> numbers) {

//        final List<Stream<Double>> variances = getMean(numbers)
//                .map(m -> numbers.stream().map(num -> elemVariance(num, m)))
//                .stream().collect(Collectors.toList());

        Optional<List<Double>> variances = getMean(numbers)
                .map(m -> numbers.stream().map(num -> elemVariance(num, m))
                        .collect(Collectors.toList()));

        return variances.flatMap(this::getMean).orElse(0.0);
    }

    private Optional<Double> getMean(Collection<Double> numbers) {
        if (numbers.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(
                numbers.stream()
                        .mapToDouble(Double::doubleValue)
                        .sum() / numbers.size());
    }

    private double elemVariance(double elem, double mean){
        return Math.pow(elem - mean, 2);
    }
}
