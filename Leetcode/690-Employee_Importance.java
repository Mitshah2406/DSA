public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> m = employees.stream().collect(Collectors.toMap(e -> e.id, Function.identity()));
    Employee employee = m.get(id);
    return getValue(m, employee, 0);
            

}