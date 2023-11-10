package tr.gov.gib.sf901datajdbc.config;

import org.modelmapper.ModelMapper;

public interface ModelMapperConfigurer {
    void configure(ModelMapper modelMapper);
}
