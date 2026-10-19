package ru.edu.pr03;

public class ApprovalRouter {

    public static final long FINANCE_LIMIT = 500_000L;

    /**
     * Определяет маршрут согласования заявки с соблюдением приоритета правил.
     *
     * @param amount сумма заявки (должна быть неотрицательной)
     * @param urgent признак срочности
     * @param risk уровень риска заявки
     * @param containsPersonalData признак наличия персональных данных
     * @return назначенный маршрут согласования
     */
    public ApprovalRoute route(long amount, boolean urgent, RiskLevel risk, boolean containsPersonalData) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма заявки не может быть отрицательной: " + amount);
        }
        if (risk == null) {
            throw new IllegalArgumentException("Уровень риска должен быть указан (не может быть null).");
        }

        if (containsPersonalData) {
            return ApprovalRoute.SECURITY_REVIEW;
        }

        if (risk == RiskLevel.HIGH) {
            return ApprovalRoute.DIRECTOR_REVIEW;
        }

        if (amount >= FINANCE_LIMIT) {
            return ApprovalRoute.FINANCE_REVIEW;
        }

        if (urgent) {
            return ApprovalRoute.FAST_TRACK;
        }
        return ApprovalRoute.STANDARD;
    }
}