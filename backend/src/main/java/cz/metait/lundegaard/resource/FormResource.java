package cz.metait.lundegaard.resource;

import cz.metait.lundegaard.model.Form;
import cz.metait.lundegaard.model.RequestType;
import cz.metait.lundegaard.request.FormRequest;
import cz.metait.lundegaard.response.RequestTypeResponse;
import cz.metait.lundegaard.service.FormService;
import cz.metait.lundegaard.utils.HeadersUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormResource {

  private final FormService formService;

  @PostMapping
  public ResponseEntity<Form> createForm(@Valid @RequestBody FormRequest request) {
    Form form = formService.createForm(request);
    return new ResponseEntity<>(form, HeadersUtils.getLocationHeaders(form.getId()), HttpStatus.CREATED);
  }

  @GetMapping("/types")
  public ResponseEntity<List<RequestTypeResponse>> getKindOfRequest() {
    return ResponseEntity.ok(formService.getRequestTypes());
  }
}
