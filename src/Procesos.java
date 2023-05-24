import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	
	ArrayList<String> listaNombres = new ArrayList<>();
	ArrayList<Double> pesoPersonas = new ArrayList<>();
	ArrayList<Double> alturaPersonas = new ArrayList<>();
	ArrayList<Double> imcPersonas = new ArrayList<>();
	Double peso,altura;
	String nombre;
	int cantidadPersonas;

	double imc;
	
	public void iniciar() {
		
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Llenar Datos\n";
		menu+="2. Imprimir Datos\n";
		menu+="3. Buscar por nombre\n";
		menu+="4. Eliminar persona\n";
		menu+="5. Actualizar persona\n";
		menu+="6. Limpiar lista\n";
		menu+="7. Salir\n";
		menu+="Ingrese una opcion:\n";
		
		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc!=7);
		
		System.out.println("Adios!!");
		
		
	}
	
	private void validarMenu(int opc) {
		
		switch (opc) {
		case 1:
			llenarDatos();
			calcularImc();
			break;
		case  2:
			operarImc();
			break;
		case 3:
			buscarNombre();
			break;
		case 4:
			eliminarDatos();
			break;
		case 5:
			actualizarDatos();
			break;
		case 6:
			limpiarDatos();
			break;
		default:
			break;
		}
		
	}

	private void actualizarDatos() {
		String nombreActualizar = "";
		for (int i = 0; i < listaNombres.size(); i++) {
			nombreActualizar = JOptionPane.showInputDialog("Dijite el nombre a actulizar: ");
		}
		if (listaNombres.contains(nombreActualizar)) {
			listaNombres.set(listaNombres.indexOf(nombreActualizar),JOptionPane.showInputDialog("Agregue el nuevo nombre:"));
		}
		
	}

	private void eliminarDatos() {
		
		String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre a eliminar: ");
			
			if (listaNombres.contains(nombreBuscar)) {
				for (int i = 0; i < listaNombres.size(); i++) {
					if (listaNombres.contains(nombreBuscar)) {
						listaNombres.remove(i);
						pesoPersonas.remove(i);
						alturaPersonas.remove(i);
						imcPersonas.remove(i);
						System.out.println("Se elimino los datos de la persona "+nombreBuscar);
					}
				} 
			}
	}

	private void limpiarDatos() {
		
		listaNombres.clear();
		pesoPersonas.clear();
		alturaPersonas.clear();
		imcPersonas.clear();
		
	}

	private void buscarNombre() {
		
		String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre a buscar: ");
		
		if (listaNombres.contains(nombreBuscar)) {
			for (int i = 0; i < listaNombres.size(); i++) {
				if (listaNombres.get(i).equalsIgnoreCase(nombreBuscar)) {
					System.out.println("El nombre "+nombreBuscar+" existe!");
				}
			}
		}else {
			System.out.println("No existe "+nombreBuscar);
		}
		
		
		
	}

	public void llenarDatos() {
		int contador = 0;
		cantidadPersonas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas personas desea registrar?"));
		do {
			nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
			listaNombres.add(nombre);
			peso = Double.parseDouble(JOptionPane.showInputDialog("Dijite el peso: "));
			pesoPersonas.add(peso);
			altura = Double.parseDouble(JOptionPane.showInputDialog("Dijite la altura: "));
			alturaPersonas.add(altura);
			
			contador++;
		} while (contador < cantidadPersonas);
	}
	
	public void calcularImc() {
		for (int i = 0; i < listaNombres.size(); i++) {
			imc = pesoPersonas.get(i) / (alturaPersonas.get(i)*alturaPersonas.get(i));
			imcPersonas.add(imc);
		}
	}
	
	public void operarImc() {
		
		for (int j = 0; j < listaNombres.size(); j++) {
			if (imcPersonas.get(j) < 18) {
				System.out.println("El IMC de "+listaNombres.get(j)+ " es de: "+imcPersonas.get(j)+" y tiene anorexia!");
			}else if(imcPersonas.get(j) >= 18 && imcPersonas.get(j) < 20) {
				System.out.println("El IMC de "+listaNombres.get(j)+ " es de: "+imcPersonas.get(j)+" y tiene delgadez!");
			}else if(imcPersonas.get(j) >= 20 && imcPersonas.get(j) < 27) {
				System.out.println("El IMC de "+listaNombres.get(j)+ " es de: "+imcPersonas.get(j)+" y esta en normalidad!");
			}else if(imcPersonas.get(j) >= 27 && imcPersonas.get(j) < 30) {
				System.out.println("El IMC de "+listaNombres.get(j)+ " es de: "+imcPersonas.get(j)+" y tiene Obseidad grado 1!");
			}else if(imcPersonas.get(j) >= 30 && imcPersonas.get(j) < 35) {
				System.out.println("El IMC de "+listaNombres.get(j)+ " es de: "+imcPersonas.get(j)+" y tiene Obseidad grado 2!");
			}else if(imcPersonas.get(j) >= 35 && imcPersonas.get(j) < 40) {
				System.out.println("El IMC de "+listaNombres.get(j)+ " es de: "+imcPersonas.get(j)+" y tiene Obseidad grado 3!");
			}else if(imcPersonas.get(j) >= 40) {
				System.out.println("El IMC de "+listaNombres.get(j)+ " es de: "+imcPersonas.get(j)+" y tiene Obseidad morbida!");
			}
		}
	}
	
}
