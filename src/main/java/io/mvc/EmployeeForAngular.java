package io.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeForAngular {

	private List<Employee> employees = Arrays.asList(new Employee(1, "AK", "ak33333@gmail.com"),
			new Employee(2, "BN", "bneman3333@yahoo.com"), new Employee(3, "JS", "john@gmail.com"),
			new Employee(4, "KJ", "kapurj@gmail.com"), new Employee(6, "PK", "apeteKerr@yahoo.com"));

	@RequestMapping("/all")
	public List<Employee> getEmployees() {
		return employees;
	}

	@RequestMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		Employee employee = employees.stream().filter(e -> e.getId() == id).findFirst().get();
		return employee;
	}

	@RequestMapping("/speedtest")
	public String speedTest() {
		List<Long> arrlist = new ArrayList<Long>();
		long start = System.nanoTime();
        int cnt = 100000000;
		for (long i = 0; i < 10000; i++) {
			arrlist.add(i);
		}
		long finish = System.nanoTime();
		long timeElapsed = finish - start;

		arrlist.add(timeElapsed);
		 double elapsedTimeInSecond = (double) timeElapsed / 1_000_000_000;
		return "elapsedTimeInSecond for :: " + cnt + " == " + elapsedTimeInSecond;
	}

}
