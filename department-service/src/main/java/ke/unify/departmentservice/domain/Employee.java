package ke.unify.departmentservice.domain;

public record Employee (Long id, Long departmentId, String name, Integer age, String position) {
}
