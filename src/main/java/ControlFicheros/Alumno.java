package ControlFicheros;

    public class Alumno {
//atributos
        String nombre;
        String apellidos;
        int anoNacimiento;
        Direccion direccion;

        //constructor
        public Alumno(String nombre, String apellidos, int anoNacimiento,
                      String calle, int numero) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.direccion = new Direccion(calle, numero);
            this.anoNacimiento = anoNacimiento;

        }
        /**         * Constructor copia         */
        public Alumno(Alumno alumno) {
            this.nombre = alumno.getNombre();
            this.apellidos = alumno.getApellidos();
            this.anoNacimiento = alumno.getAnoNacimiento();
            this.direccion = new Direccion(alumno.direccion);

        }

        //crear la dirreción
        public void setDireccion(String calle, int numero) {
            this.direccion.setCalle(calle);
            this.direccion.setNumero(numero);
        }

        public String getDireccion() {
            return direccion.calle + " " + direccion.numero;
        }
        public String getApellidos() {
            return apellidos;
        }
        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }
        public int getAnoNacimiento() {
            return anoNacimiento;
        }
        public void setAnoNacimiento(int anoNacimiento) {
            this.anoNacimiento = anoNacimiento;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String toString() {
            return "El alumno se llama:" + getNombre() + " " + getApellidos()
                    + "\tNaci� en el a�o:" + getAnoNacimiento()
                    + "\tVive en la calle:" + getDireccion();

        }

        /**         * Clase interna para representar una direcci�n         */
        private class Direccion {
            String calle;
            int numero;

            private Direccion(String calle, int numero) {
                this.calle = calle;
                this.numero = numero;
            }

            private Direccion(Direccion direccion) {
                this.calle = direccion.getCalle();
                this.numero = direccion.getNumero();
            }

            private String getCalle() {
                return calle;
            }
            private void setCalle(String calle) {
                this.calle = calle;
            }
            private int getNumero() {
                return numero;
            }
            private void setNumero(int numero) {
                this.numero = numero;
            }
        }

}
