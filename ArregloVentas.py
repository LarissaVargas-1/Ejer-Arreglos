class ArregloVentas:
    def __init__(self):
        self.ventas = [[0.0 for _ in range(12)] for _ in range(3)]
        self.departamentos = ["Ropa", "Deportes", "Juguetería"]
        self.meses = [
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        ]

    def _validar_indices(self, depto, mes):
        if 0 <= depto < 3 and 0 <= mes < 12:
            return True
        print("\n⚠️ Error: Opciones fuera de rango (Depto: 0-2, Mes: 0-11).")
        return False

    def insertar_venta(self, depto, mes, monto):
        if self._validar_indices(depto, mes):
            self.ventas[depto][mes] = monto
            print(f"\n✅ Venta de ${monto:.2f} registrada en {self.departamentos[depto]} ({self.meses[mes]}).")

    def buscar_venta(self, depto, mes):
        if self._validar_indices(depto, mes):
            monto = self.ventas[depto][mes]
            print(f"\n🔍 Venta encontrada: ${monto:.2f} en {self.departamentos[depto]} ({self.meses[mes]}).")

    def eliminar_venta(self, depto, mes):
        if self._validar_indices(depto, mes):
            self.ventas[depto][mes] = 0.0
            print(f"\n🗑️ Venta eliminada ($0.0) para {self.departamentos[depto]} en {self.meses[mes]}.")


def ejecutar_menu():
    gestor = ArregloVentas()
    
    while True:
        print("\n=== GESTIÓN DE VENTAS MENSUALES ===")
        System_menu = ("1. Insertar / Actualizar Venta\n"
                       "2. Buscar Venta\n"
                       "3. Eliminar Venta\n"
                       "4. Salir")
        print(System_menu)
        
        try:
            opcion = int(input("Selecciona una opción: "))
            if opcion == 4:
                print("Programa finalizado.")
                break
            
            if 1 <= opcion <= 3:
                depto = int(input("Selecciona Departamento (0: Ropa, 1: Deportes, 2: Juguetería): "))
                mes = int(input("Selecciona Mes (0: Enero, 1: Febrero, ... 11: Diciembre): "))
                
                if opcion == 1:
                    monto = float(input("Ingresa el monto de la venta: $"))
                    gestor.insertar_venta(depto, mes, monto)
                elif opcion == 2:
                    gestor.buscar_venta(depto, mes)
                elif opcion == 3:
                    gestor.eliminar_venta(depto, mes)
            else:
                print("Opción no válida.")
        except ValueError:
            print("\n⚠️ Entrada inválida. Por favor ingresa números enteros para índices y numéricos para montos.")

if __name__ == "__main__":
    ejecutar_menu()