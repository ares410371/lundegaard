package cz.metait.lundegaard.service;

import cz.metait.lundegaard.model.Form;
import cz.metait.lundegaard.model.RequestType;
import cz.metait.lundegaard.request.FormRequest;
import cz.metait.lundegaard.response.RequestTypeResponse;

import java.util.List;

public interface FormService {

  Form createForm(FormRequest request);

  List<RequestTypeResponse> getRequestTypes();
}
