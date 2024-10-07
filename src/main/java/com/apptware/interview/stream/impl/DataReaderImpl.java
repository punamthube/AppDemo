package com.apptware.interview.stream.impl;

import com.apptware.interview.stream.DataReader;
import com.apptware.interview.stream.PaginationService;
import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class DataReaderImpl implements DataReader {

  @Autowired private PaginationService paginationService;

  @Override
  public Stream<String> fetchLimitadData(int limit) {
    return fetchPaginatedDataAsStream().limit(limit);
  }

  @Override
  public Stream<String> fetchFullData() {
    return fetchPaginatedDataAsStream();
  }

  /**
   * This method is where the candidate should add the implementation. Logs have been added to track
   * the data fetching behavior. Do not modify any other areas of the code.
   */
  private @Nonnull Stream<String> fetchPaginatedDataAsStream() {
    log.info("Fetching paginated data as stream.");

    // Placeholder for paginated data fetching logic
    // The candidate will add the actual implementation here
   // String a= "Punam";
    List<String> list = new ArrayList<>();
    /*list.add("Punam");
    list.add("Thube");
    list.add("Car");
    list.add("fan");*/


    List<String> stringList = generateStringList(10000);

    Stream<String> dataStream =
        //Stream.empty(); // Temporary, will be replaced by the actual data stream

            stringList.stream();
    return dataStream.peek(item -> log.info("Fetched Item: {}", item));
  }
  private static List<String> generateStringList(int count) {
    return IntStream.range(0, count)
            .mapToObj(i -> "String " + (i + 1)) // Generate strings "String 1", "String 2", ..., "String 1000"
            .collect(Collectors.toList());
  }
}
