package transport;

import java.util.Objects;

public class Mechanic <T extends Transport> {

    private String name;
    private String company;

    public Mechanic(String name, String company) {
        this.name = Utility.checkNull(name,"default");
        this.company = Utility.checkNull(company,"default");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Utility.checkNull(name,"default");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = Utility.checkNull(company,"default");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }

    public boolean performMaintenance (T t) {
        if (!t.passDiagnostics()) {
            return t.passDiagnostics();
        } else {
            fixTheCar(t);
        }
        return true;
    }

    public void fixTheCar (T t) {
        t.repair();
    }
}
