class Badge {
    public String print(Integer id, String name, String department) {
        StringBuilder sb = new StringBuilder();

        if (id != null) {
            sb.append("[" + id + "] - ");
        }

        if (department == null) {
            department = "OWNER";
        }

        sb.append(name).append(" - ").append(department.toUpperCase());

        return sb.toString();
    }
}
