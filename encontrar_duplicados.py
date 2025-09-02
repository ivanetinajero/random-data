# Script para encontrar apellidos duplicados en data/apellidos.txt

def encontrar_duplicados(ruta_archivo):
    with open(ruta_archivo, 'r', encoding='utf-8') as f:
        apellidos = [linea.strip() for linea in f if linea.strip()]
    
    vistos = set()
    duplicados = set()
    for apellido in apellidos:
        if apellido in vistos:
            duplicados.add(apellido)
        else:
            vistos.add(apellido)
    return duplicados

if __name__ == "__main__":
    archivo = "data/nombres.txt"
    duplicados = encontrar_duplicados(archivo)
    if duplicados:
        print("Registros duplicados encontrados:")
        for apellido in sorted(duplicados):
            print(apellido)
    else:
        print("No se encontraron registros duplicados.")
