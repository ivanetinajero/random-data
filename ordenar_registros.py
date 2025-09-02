# Script para ordenar alfabeticamente los elementos en data/nombres.txt

def ordenar_nombres(ruta_archivo):
    with open(ruta_archivo, 'r', encoding='utf-8') as f:
        nombres = [linea.strip() for linea in f if linea.strip()]
    
    nombres_ordenados = sorted(nombres, key=lambda x: x.lower())
    
    with open(ruta_archivo, 'w', encoding='utf-8') as f:
        for nombre in nombres_ordenados:
            f.write(nombre + '\n')

if __name__ == "__main__":
    archivo = "data/apellidos.txt"
    ordenar_nombres(archivo)
    print("Archivo ordenado alfabeticamente.")
