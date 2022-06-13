import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '../../generic/dynamic-grid.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-pages/iron-pages.js';

class ArticuloForm extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }          
      vaadin-text-field.veryBig{
                width: var(--vaadin-text-field-default-width, 28em);
                margin-left: 5px;
      }
      
      vaadin-text-field.big{
                width: var(--vaadin-text-field-default-width, 20em);
                margin-left: 5px;
      }
      vaadin-text-field.medium{
                width: var(--vaadin-text-field-default-width, 10em);
                margin-left: 5px;
            }
      vaadin-text-field.veryVerySmall{
                width: var(--vaadin-text-field-default-width, 2em);
                margin-left: 5px;
            }
      vaadin-text-field.veryVerySmall3{
                width: var(--vaadin-text-field-default-width, 3em);
                margin-left: 5px;
            }
      vaadin-text-field.verySmall{
            width: var(--vaadin-text-field-default-width, 4em);  
 				margin-left: 5px;
             }  
      vaadin-text-field.verySmall5{
            width: var(--vaadin-text-field-default-width, 5em);  
 				margin-left: 5px;
             }  
      vaadin-text-field.small{
                width: var(--vaadin-text-field-default-width, 8em);
                margin-left: 5px;
            }  
      vaadin-date-picker {
      			width: var(--vaadin-text-field-default-width, 10em);
      			margin-left: 5px;
      }  
      div.linCampos {
/*       margin-top: 0px; */
      margin-left: 20px;
/*       height: 70px; */
/*       text-align:justify; */
/*       	display: flex;  */
      
/*        justify-content: left;  */
      } 
      div.lastColumn {
      float:right;
      margin-right:24px;
      }     
/*       vaadin-form-item{ */
/*       	background-color: rgba(0, 0, 0, 0.05); */
/*             }                 */
/* /*       vaadin-text-field { */ */
/* /*   	border: 10px solid gray; */ */
/*   	height:"100px""; */
  	
/* 		} */
	clean{
		padding-right:  0.75rem; margin-right: 0px;
	}
	/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
				.cel {
        			display:inline-block;
        			width: 100%;
					min-width:320px;
				    padding: 1em;
				    text-align: center;
				    color: lightgray;
	            }
  page {
    display: flex;
    flex-direction: column;
    align-items: center;
    width:100%;
  }
fieldset {
    color: #29477d;
    font-size: 15px;
    border: 1px solid #4c6ba3;
    width:100%;
}

    </style>
<h3 id="title" style="height:0px"></h3>
<vaadin-form-layout id="form"></vaadin-form-layout>
<div class="linCampos">
<vaadin-integer-field id="col0" class="verySmall" label="Clave"></vaadin-integer-field>
 <vaadin-text-field id="col1" class="big" label="Descripción"></vaadin-text-field>
 <vaadin-text-field id="col2" label="Dimensiones"></vaadin-text-field>
 <vaadin-text-field id="col11" class="veryVerySmall" label="UM"></vaadin-text-field>
 <vaadin-integer-field id="col12" class="verySmall" label="NPV"></vaadin-integer-field>
 <vaadin-integer-field id="col25" class="verySmall" label="Cod Ede"></vaadin-integer-field>
 <vaadin-integer-field id="col26" class="verySmall" label="SubCod Ede"></vaadin-integer-field>
 <span inner-h-t-m-l=[[item.HTML]] id="col160"></span>
</div>
<div class="cel" id="cell1">
 <vaadin-tabs selected="{{page1}}" id="tbTab1">
  <vaadin-tab on-click="handleClickTabStock">
    Stock 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabValores">
    Valores 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabImportes">
    Importes 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabDatos">
    Datos 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabEvol">
    Evolución Diaria 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabVar">
    Varios
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabAlter">
    Alternativos
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabTarif">
    Tarifa Clientes
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabAlterOfertas">
    Ofertas 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabOfProv">
    Ofertas Proveedor 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabConsProv">
    Consultas Proveedor
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabColec">
    Colección 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabTrans">
    Transformados 
  </vaadin-tab>
  <vaadin-tab on-click="handleClickTabFicha">
    Ficha 
  </vaadin-tab>
 </vaadin-tabs>
 <iron-pages selected="[[page1]]" style="width: 1360px;align-items: baseline;">
  <page>
   <div style="width:1360px; display:inline-flex;">
    <fieldset style="width:460px;">
     <legend>Salidas</legend>
     <div id="divpage111">
      <vaadin-text-field id="col43" label="Pedidas" style="width: 110px;"></vaadin-text-field>
      <vaadin-text-field id="col15" label="Pendiente Servir" style="width: 110px;"></vaadin-text-field>
      <vaadin-text-field id="col50" label="Venta Media" style="width: 110px;"></vaadin-text-field>
     </div>
    </fieldset>
    <fieldset style="width:460px;">
     <legend>Stock</legend>
     <div id="divpage112">
      <vaadin-text-field id="col42" label="Iniciales" style="width: 110px;"></vaadin-text-field>
      <vaadin-text-field id="col13" label="Stock" style="width: 110px;"></vaadin-text-field>
      <vaadin-text-field id="col44" label="Mínimo" style="width: 110px;"></vaadin-text-field>
     </div>
    </fieldset>
    <fieldset style="width:460px;">
     <legend>Entradas</legend>
     <div id="divpage21">
      <vaadin-text-field id="col40" label="Propuestas" style="width: 110px;"></vaadin-text-field>
      <vaadin-text-field id="col41" label="Pedidas" style="width: 110px;"></vaadin-text-field>
      <vaadin-text-field id="col14" label="Pendiente Recibir" style="width: 110px;"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col16" label="Cantidad Neta a Pedir" style="width: 110px;"></vaadin-text-field>
      <vaadin-combo-box id="col134" label="Plazo Entrega" style="width: 110px;"></vaadin-combo-box>
      <vaadin-text-field id="col161" label="Int. Pedido" style="width: 110px;"></vaadin-text-field>
     </div>
    </fieldset>
   </div>
  </page>
  <page>
   <div style="width:100%; display:inline-flex;">
    <fieldset style="width:450px;">
     <legend>Iniciales</legend>
     <div id="divpage12">
      <vaadin-text-field id="col125" label="Cantidad"></vaadin-text-field>
      <vaadin-text-field id="col47" label="Valor CM"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col45" label="Coste Medio"></vaadin-text-field>
      <vaadin-text-field id="col46" label="CUE"></vaadin-text-field>
     </div>
    </fieldset>
    <fieldset style="width:450px;">
     <legend>Actual</legend>
     <div id="divpage22">
      <vaadin-text-field id="col128" label="Cantidad"></vaadin-text-field>
      <vaadin-text-field id="col48" label="Valor CM"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col49" label="Coste Medio"></vaadin-text-field>
      <vaadin-text-field id="col39" label="CUE"></vaadin-text-field>
     </div>
    </fieldset>
   </div>
  </page>
  <page>
   <div style="width:100%; display:inline-flex;">
    <fieldset style="min-width:304px;width:304px;">
     <legend>Costes</legend>
     <div id="divpage13">
      <vaadin-text-field id="col79" label="Tarifa" class="small"></vaadin-text-field>
      <vaadin-text-field id="col81" label="Comercial" class="small"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col94" label="Borrador" class="small"></vaadin-text-field>
      <div style="width:130px;display: inline-flex;top: -15px;position: relative;font-weight: 500;font-size: 11px;color: #000040;">
       <div style="display: inline-block;width: 50%;line-height: 4px;">
        <span>C. Especial</span>
        <br>
        <vaadin-checkbox id="col99" style="top: 10px;"></vaadin-checkbox>
       </div>
       <div style="display: inline-block;width: 50%;line-height: 4px;">
        <span>Exento Icf</span>
        <br>
        <vaadin-checkbox id="col102" style="top: 10px;"></vaadin-checkbox>
       </div>
      </div>
      <br>
      <vaadin-text-field id="col97" label="Compra" class="small"></vaadin-text-field>
      <vaadin-text-field id="col100" label="Comerc. 2" class="small"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col80" label="Contable" class="small"></vaadin-text-field>
      <vaadin-text-field id="col98" label="Reciclaje" class="small"></vaadin-text-field>
      <br>
      <vaadin-date-picker id="col82" label="Mod Trf Man" class="small"></vaadin-date-picker>
      <vaadin-date-picker id="col103" label="Mod Trf Auto" class="small"></vaadin-date-picker>
     </div>
    </fieldset>
    <fieldset style="min-width:445px;width:445px;">
     <legend>Descuentos</legend>
     <div style="margin: 0 auto;">
      <div style="width:100%;display:flex;">
       <div style="width:176px;display:inline-block;">
        <vaadin-integer-field id="col24" class="verySmall" label="Clave" style="width:70px;"></vaadin-integer-field>
        <vaadin-integer-field id="col95" class="verySmall" label="Borrador" style="width:70px;"></vaadin-integer-field>
       </div>
       <fieldset style="min-width:240px;width:240px;display: inline-flex;">
        <legend>Descuentos</legend>
        <vaadin-text-field id="col78" style="width:100px;" label="Contable"></vaadin-text-field>&nbsp; 
        <vaadin-text-field id="col83" style="width: 100px;" label="Comercial"></vaadin-text-field7
       </fieldset>
      </div>
      <div style="width:100%;display:flex;">
       <fieldset style="width:285px;min-width:285px;display: inline-block;text-align: left;">
        <legend style="font-size:11px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(A)Dctos.&nbsp;&nbsp;&nbsp;&nbsp;(B)Bonific.&nbsp;&nbsp;(C)Rappels&nbsp;(D)Increm.</legend>
        1&nbsp; 
        <vaadin-text-field id="col85" style="width: 52px;"></vaadin-text-field>
        <vaadin-text-field id="col89" style="width: 52px;"></vaadin-text-field>
        <vaadin-text-field id="col92" style="width: 52px;"></vaadin-text-field>
        <vaadin-text-field id="col123" style="width: 52px;"></vaadin-text-field>
        <br> 2&nbsp; 
        <vaadin-text-field id="col86" style="width: 52px;"></vaadin-text-field>
        <vaadin-text-field id="col90" style="width: 52px;"></vaadin-text-field>
        <vaadin-text-field id="col93" style="width: 52px;"></vaadin-text-field>
        <vaadin-text-field id="col124" style="width: 52px;"></vaadin-text-field>
        <br> 3&nbsp; 
        <vaadin-text-field id="col87" style="width: 52px;"></vaadin-text-field>
        <vaadin-text-field id="col91" style="width: 52px;"></vaadin-text-field>
        <br> 4&nbsp; 
        <vaadin-text-field id="col88" style="width: 52px;"></vaadin-text-field>
       </fieldset>
       <fieldset style="width:115px;display: inline-block;">
        <legend>Patrón</legend>
        <div style="text-align: left;margin-left: 2px;font-size: 16px;">
         <span style="color: #000040;">A &nbsp; &nbsp;&nbsp; B &nbsp; C &nbsp;D</span>
         <br>
         <span style="color: #000040;">12341231212 </span>
        </div>
        <vaadin-text-field id="col84" style="width:104px;"></vaadin-text-field>
       </fieldset>
      </div>
     </div>
    </fieldset>
    <fieldset style="min-width: 235px;width: 235px;text-align: left;">
     <legend>Precios</legend>
     <div>
      <vaadin-text-field id="col58" style="width: 100px;" label="Intercambio"></vaadin-text-field>
      <vaadin-text-field id="col55" style="width: 100px;" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col53" style="width: 100px;" label="Mayor Neto"></vaadin-text-field>
      <vaadin-text-field id="col56" style="width: 100px;" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col52" style="width: 100px;" label="PVP"></vaadin-text-field>
      <vaadin-text-field id="col57" style="width: 100px;" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col76" style="width: 100px;" label="Precio Corte"></vaadin-text-field>  
      <br>
      <vaadin-integer-field id="col36" style="width: 100px;" label="Clave" style="width:70px;"></vaadin-integer-field>
      <vaadin-integer-field id="col60" style="width: 100px;" label="Borrador" style="width:70px;"></vaadin-integer-field>
     </div>
    </fieldset>
    <fieldset style="min-width: 235px; width: 235px;">
     <legend>Precios Tienda</legend>
     <div>
      <vaadin-text-field id="col63" style="width: 100px;" label="Mínimo"></vaadin-text-field>
      <vaadin-text-field id="col61" style="width: 100px;" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col64" style="width: 100px;" label="Intercambio"></vaadin-text-field>
      <vaadin-text-field id="col62" style="width: 100px;" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col74" style="width: 100px;" label="Objetivo"></vaadin-text-field>
      <vaadin-text-field id="col75" style="width: 100px;" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col67" style="width: 100px;" label="PVP"></vaadin-text-field>
      <vaadin-text-field id="col68" style="width: 100px;"></vaadin-text-field>
      <br>
      <span style="width:100%;text-align:center;"><vaadin-button id="btDetalle" style="top: 4px;">+ detalle</vaadin-button></span>






     </div>
    </fieldset>
   </div>
  </page>
  <page>
   <div style="width:100%; display:inline-flex;">
    <fieldset style="width:600px">
     <div style="text-align: left;margin: 0 auto;">
      <div>
       <vaadin-text-field id="col10" style="width:80px;" label="Ref. Proveedor"></vaadin-text-field>
       <vaadin-text-field id="col21" class="small" label="EAN 13"></vaadin-text-field>
       <vaadin-button theme="icon" style="top:5px;left:-4px;" id="btEan">
        <iron-icon icon="lumo:plus"></iron-icon>
       </vaadin-button>
       <vaadin-combo-box id="col20" style="width:50px;" label="Clase"></vaadin-combo-box>
       <vaadin-integer-field id="col105"  style="width:50px;" label="IVA"></vaadin-integer-field>
       <vaadin-text-field id="col27" class="veryVerySmall" label="Dest."></vaadin-text-field>
      </div>
      <div>
       <vaadin-text-field id="col110" style="width:80px;" label="Info Tarifa"></vaadin-text-field>
       <vaadin-text-field id="col108" class="veryVerySmall" label="UCA"></vaadin-text-field>
       <vaadin-integer-field id="col109" style="width:70px;" label="UxUCA"></vaadin-integer-field>
       <vaadin-integer-field id="col122" style="width:70px;" label="ULC"></vaadin-integer-field>
       <vaadin-integer-field id="col114" style="width:70px;" label="UxULC"></vaadin-integer-field>
       <vaadin-text-field id="col106" class="veryVerySmall" label="UVA"></vaadin-text-field>
       <vaadin-integer-field id="col107" style="width:70px;" label="UxUVA"></vaadin-integer-field>
      </div>
      <div>
       <vaadin-text-field id="col7" class="veryVerySmall3" label="Prov"></vaadin-text-field>
       <vaadin-integer-field id="col120" style="width:80px;" label="Cta.P.Tar"></vaadin-integer-field>
       <vaadin-button style="margin-right:20px;top:5px;left:-4px;" id="btProv">
         Prov 
       </vaadin-button>
       <vaadin-integer-field id="col121" style="width:80px;" label="Comprador"></vaadin-integer-field>
       <vaadin-text-field id="col104" class="verySmall" label="Peso Teóric"></vaadin-text-field>
       <vaadin-text-field id="col37" class="veryVerySmall3" label="Estac."></vaadin-text-field>
      </div>
      <div>
       <vaadin-text-field id="col115" class="veryVerySmall3" label="Largo"></vaadin-text-field>
       <vaadin-text-field id="col116" class="veryVerySmall3" label="Ancho"></vaadin-text-field>
       <vaadin-text-field id="col77" style="width:80px;" label="Cód.Intrastat"></vaadin-text-field>
       <vaadin-combo-box id="col119" label="Zona Almacén" style="width: 230px;"></vaadin-combo-box>
      </div>
     </div>
    </fieldset>
    <fieldset style="width:450px">
     <div style="text-align: left;margin: 0 auto;width: 406px;">
      <div>
       <vaadin-integer-field id="col4" style="width:50px;" label="Cap"></vaadin-integer-field>
       <vaadin-integer-field id="col5" style="width:50px;" label="Gru"></vaadin-integer-field>
       <vaadin-integer-field id="col6" style="width:50px;" label="Sub"></vaadin-integer-field>
       <div style="display: inline-flex;top: -15px;position: relative;font-weight: 500;font-size: 11px;color: #000040;">
        <div style="display: inline-block;line-height: 4px;">
         <span>Web</span>
         <br>
         <vaadin-checkbox id="col59" style="top: 10px;"></vaadin-checkbox>
        </div>
       </div>
       <vaadin-text-field id="col38" class="veryVerySmall" label="Tipo"></vaadin-text-field>
       <vaadin-integer-field id="col65" style="width:50px;" label="Área"></vaadin-integer-field>
      </div>
      <div>
       <vaadin-date-picker id="col54" style="margin-left:0;" label="Fecha Recuento 1"></vaadin-date-picker>
       <vaadin-date-picker id="col73" label="Fecha Recuento 2"></vaadin-date-picker>
       <vaadin-text-field id="col3" class="veryVerySmall3" label="Fab"></vaadin-text-field>
      </div>
      <div>
       <vaadin-combo-box id="col69" style="width:130px" label="Unidad Produc."></vaadin-combo-box>
       <vaadin-text-field id="col70" class="verySmall" label="Cant.Prod."></vaadin-text-field>
       <vaadin-integer-field id="col19" style="width:80px;" label="Clave Distrits"></vaadin-integer-field>
       <vaadin-integer-field id="col23" style="width:80px;" label="Clave ferret"></vaadin-integer-field>
      </div>
      <div>
       <vaadin-date-picker id="col96" style="margin-left:0;" label="Fecha Alta"></vaadin-date-picker>
       <vaadin-text-field id="col101" class="verySmall" label="Usuar.Alta"></vaadin-text-field>
       <vaadin-text-field id="col28" class="veryVerySmall" label="Orig."></vaadin-text-field>
       <vaadin-text-field id="col22" class="veryVerySmall3" label="Antiguo"></vaadin-text-field>
      </div>
     </div>
    </fieldset>
   </div>
  </page>
  <page>
   <div id="dvEvol" style="width: 100%;max-height:250px;">
    <dynamic-grid id="dgEvol" style="display:none;"></dynamic-grid>
   </div>
  </page>
  <page style="display: block;">
   <vaadin-text-field id="col111" label="Observaciones 1" style="width: 45%;"></vaadin-text-field>
   <vaadin-text-field id="col112" label="Observaciones 2" style="width: 45%;"></vaadin-text-field>
   <br>
   <vaadin-text-field id="col113" label="Observaciones 3" style="width: 45%;"></vaadin-text-field>
   <vaadin-text-field id="col118" label="Aviso Presupuesto y Pedido" style="width: 45%;"></vaadin-text-field>
   <br>
   <vaadin-button id="btArtSus">
     Artículos Sustitutivos 
   </vaadin-button>
   <vaadin-button id="btProvAlter">
     Proveedores Alternativos 
   </vaadin-button>
  </page>
  <page>
   <div id="dvAlter" style="width: 100%;max-height:250px;">
    <dynamic-grid id="dgAlter" style="display:none;"></dynamic-grid>
   </div>
  </page>
  <page>
   <div id="dvTarif" style="width: 100%;max-height:250px;">
    <div style="width: 49%;display: inline-block;">
     <dynamic-grid id="dgTarif1" style="display:none;"></dynamic-grid>
    </div>
    <div style="width: 49%;display: inline-block;">
     <dynamic-grid id="dgTarif2" style="display:none;"></dynamic-grid>
    </div>
   </div>
  </page>
  <page>
   <div id="dvOferta" style="width: 100%;max-height:250px;">
    <div style="width: 49%;display: inline-block;">
     <dynamic-grid id="dgOferta1" style="display:none;"></dynamic-grid>
    </div>
    <div style="width: 49%;display: inline-block;max-height:250px;">
     <dynamic-grid id="dgOferta2" style="display:none;"></dynamic-grid>
    </div>
   </div>
  </page>
  <page>
   <div id="dvOfProv" style="width: 100%;max-height:250px;">
    <dynamic-grid id="dgOfProv" style="display:none;"></dynamic-grid>
   </div>
  </page>
  <page>
   <div id="dvConsProv" style="width: 100%;max-height:250px;">
    <dynamic-grid id="dgConsProv" style="display:none;"></dynamic-grid>
   </div>
  </page>
  <page>
   <div id="dvColec" style="width: 100%;max-height:250px;">
    <dynamic-grid id="dgColec" style="display:none;"></dynamic-grid>
   </div>
  </page>
  <page>
   <div id="dvTrans" style="width: 100%;max-height:250px;">
    <div style="width: 49%;display: inline-block;">
     <dynamic-grid id="dgTrans1" style="display:none;"></dynamic-grid>
    </div>
    <div style="width: 49%;display: inline-block;">
     <dynamic-grid id="dgTrans2" style="display:none;"></dynamic-grid>
    </div>
   </div>
  </page>
  <page>
   <div id="dvFicha" style="width: 100%;max-height:250px;">
    <dynamic-grid id="dgFicha" style="display:none;"></dynamic-grid>
   </div>
  </page>
 </iron-pages>
</div>
<vaadin-dialog id="dialogForPick"></vaadin-dialog>
`;
    }

    static get is() {
        return 'articulo-form';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ArticuloForm.is, ArticuloForm);
