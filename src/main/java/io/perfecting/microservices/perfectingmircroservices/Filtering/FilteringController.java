package io.perfecting.microservices.perfectingmircroservices.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return  new SomeBean("Value1", "Value2", "Value3");
    }

    @GetMapping("/filter-list")
    public List<SomeBean> listsOfFilters(){
        return Arrays.asList(
                new SomeBean("Value1", "Value2", "Value3"),
                new SomeBean("Value4", "Value5", "Value6")
                );
    }

//    Implementing Dynamic filtering of class attributes *** filters all except field1 and field2
        @GetMapping("/dynamic-filter-val1-val2")
        public MappingJacksonValue dynamicFiltering(){
            SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
            SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
            FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
            MappingJacksonValue mapping =  new MappingJacksonValue(someBean);
            mapping.setFilters(filters);
            return mapping;
        }

    //    Implementing Dynamic filtering of class attributes *** filters all except field1 and field3
    @GetMapping("/dynamic-filter-val1-val3")
    public MappingJacksonValue dynamicFilteringListForField1AndFiled3() {
        List<SomeBean> list = Arrays.asList(
                new SomeBean("Value1", "Value2", "Value3"),
                new SomeBean("Value4", "Value5", "Value6")
        );
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;

    }

}
