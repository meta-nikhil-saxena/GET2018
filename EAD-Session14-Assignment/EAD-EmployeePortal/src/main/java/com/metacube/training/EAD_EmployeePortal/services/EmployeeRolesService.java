package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;
import com.metacube.training.EAD_EmployeePortal.models.EmployeeRole;

public interface EmployeeRolesService {

	List<EmployeeRole> getInfoByEmail(String email);
}
