# Script para detectar caracteres extraños en un archivo de texto
# Guarda este archivo como revisar_caracteres.py y ejecútalo en la terminal

import sys
import unicodedata

filename = "data/apellidos.txt"

caracteres_validos = set("-.'\n ")
caracteres_validos.update("ÑñÁÉÍÓÚÜáéíóúü")

with open(filename, "r", encoding="utf-8") as f:
    for i, line in enumerate(f, 1):
        for c in line:
            if not (c.isascii() and (c.isalnum() or c.isspace() or c in "-.'\n")):
                if c not in caracteres_validos:
                    print(f"Línea {i}: '{line.strip()}' -> Carácter extraño: '{c}' (U+{ord(c):04X}, {unicodedata.name(c, 'UNKNOWN')})")
