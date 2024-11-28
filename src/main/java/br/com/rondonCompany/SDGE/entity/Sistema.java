package br.com.rondonCompany.SDGE.entity;

public class Sistema {
    public static class AlunoSessao{
        private static Long id;

        public static Long getId() {
            return id;
        }

        public static void setId(Long id) {
            AlunoSessao.id = id;
        }
    }
}
