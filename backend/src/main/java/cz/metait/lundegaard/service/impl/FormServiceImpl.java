package cz.metait.lundegaard.service.impl;

import cz.metait.lundegaard.error.RequestTypeNotFound;
import cz.metait.lundegaard.model.Form;
import cz.metait.lundegaard.model.RequestType;
import cz.metait.lundegaard.repository.FormRepository;
import cz.metait.lundegaard.repository.RequestTypeRepository;
import cz.metait.lundegaard.request.FormRequest;
import cz.metait.lundegaard.response.RequestTypeResponse;
import cz.metait.lundegaard.service.FormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

  private final FormRepository formRepository;
  private final RequestTypeRepository requestTypeRepository;

  @Override
  public Form createForm(FormRequest request) {
    Form form = new Form();
    form.setPolicyNumber(request.getPolicyNumber());
    form.setName(request.getName());
    form.setSurname(request.getSurname());
    form.setRequest(request.getRequest());

    RequestType type = requestTypeRepository
        .getByName(request.getRequestType())
        .orElseThrow(() -> new RequestTypeNotFound(request.getRequestType()));
    form.setRequestType(type);

    formRepository.save(form);
    return form;
  }

  @Override
  public List<RequestTypeResponse> getRequestTypes() {
    return requestTypeRepository.findAll().stream()
        .map(type -> new RequestTypeResponse(type.getName(), type.getName())).collect(Collectors.toList());
  }
}
