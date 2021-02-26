import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '../../generic/dynamic-grid.js';

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
		padding-right:  0.75rem; margin-right: 0px;"
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
    color: #9a3261;
    font-size: smaller;
    border: 1px solid #9a3261;
    width:100%;
}

    </style>
<h3 id="title" style="height:0px"></h3>
<vaadin-form-layout id="form"></vaadin-form-layout>
<div class="linCampos">
 <vaadin-text-field id="col0" class="verySmall" label="Clave" readonly="true"></vaadin-text-field>
 <vaadin-text-field id="col1" class="big" label="Descripción" readonly="true"></vaadin-text-field>
 <vaadin-text-field id="col2" label="Dimensiones" readonly="true"></vaadin-text-field>
 <vaadin-text-field id="col11" class="veryVerySmall" label="UM" readonly="true"></vaadin-text-field>
 <vaadin-text-field id="col12" class="verySmall" label="NPV" readonly="true"></vaadin-text-field>
 <vaadin-text-field id="col25" class="verySmall" label="Cod Ede" readonly="true"></vaadin-text-field>
 <vaadin-text-field id="col26" class="verySmall" label="SubCod Ede" readonly="true"></vaadin-text-field>
</div>
<div class="cel" id="cell1">
 <vaadin-tabs selected="{{page1}}">
  <vaadin-tab>
    Stock 
  </vaadin-tab>
  <vaadin-tab>
    Valores 
  </vaadin-tab>
  <vaadin-tab>
    Importes 
  </vaadin-tab>
  <vaadin-tab>
    Datos 
  </vaadin-tab>
  <vaadin-tab>
    Evol.Diaria 
  </vaadin-tab>
  <vaadin-tab>
    Var 
  </vaadin-tab>
  <vaadin-tab>
    Alter 
  </vaadin-tab>
  <vaadin-tab>
    Tar.Clie 
  </vaadin-tab>
  <vaadin-tab>
    Ofertas 
  </vaadin-tab>
  <vaadin-tab>
    Of.Prov 
  </vaadin-tab>
  <vaadin-tab>
    Cons.Prov 
  </vaadin-tab>
  <vaadin-tab>
    Colección 
  </vaadin-tab>
  <vaadin-tab>
    Transformados 
  </vaadin-tab>
  <vaadin-tab>
    Ficha 
  </vaadin-tab>
 </vaadin-tabs>
 <iron-pages selected="[[page1]]">
  <page>
   <div style="width:100%; display:inline-flex;">
    <fieldset style="width:25%;">
     <legend>Salidas</legend>
     <div id="divpage111">
      <vaadin-text-field id="col43" label="Pedidas" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col15" label="Pdtes. servir"></vaadin-text-field>
      <vaadin-text-field id="col50" label="Venta Media" readonly="true"></vaadin-text-field>
     </div>
    </fieldset>
    <fieldset style="width:25%;">
     <legend>Stock</legend>
     <div id="divpage112">
      <vaadin-text-field id="col42" label="Iniciales" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col13" label="Stock" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col44" label="Mínimo" readonly="true"></vaadin-text-field>
     </div>
    </fieldset>
    <fieldset style="width:50%;">
     <legend>Entradas</legend>
     <div id="divpage21">
      <vaadin-text-field id="col40" label="Propuestas" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col16" label="Cantidad Neta a Pedir" readonly="true"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col41" label="Pedidas" readonly="true"></vaadin-text-field>
      <vaadin-combo-box id="col117" label="Plazo Entrega"></vaadin-combo-box>
      <br>
      <vaadin-text-field id="col14" label="Pdtes. Recibir" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col51" label="Int. Pedido" readonly="true"></vaadin-text-field>
     </div>
    </fieldset>
   </div>
  </page>
  <page>
   <div style="width:100%; display:inline-flex;">
    <fieldset style="width:50%;">
     <legend>Iniciales</legend>
     <div id="divpage12">
      <vaadin-text-field id="col125" label="Cantidad" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col47" label="Valor CM" readonly="true"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col45" label="Coste Medio" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col46" label="CUE" readonly="true"></vaadin-text-field>
     </div>
    </fieldset>
    <fieldset style="width:50%;">
     <legend>Actual</legend>
     <div id="divpage22">
      <vaadin-text-field id="col13" label="Cantidad" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col48" label="Valor CM" readonly="true"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col49" label="Coste Medio" readonly="true"></vaadin-text-field>
      <vaadin-text-field id="col39" label="CUE" readonly="true"></vaadin-text-field>
     </div>
    </fieldset>
   </div>
  </page>
  <page>
   <div style="width:100%; display:inline-flex;">
    <fieldset style="min-width:300px">
     <legend>Costes</legend>
     <div id="divpage13">
      <vaadin-text-field id="col79" label="Tarifa" readonly="true" class="small"></vaadin-text-field>
      <vaadin-text-field id="col81" label="Comercial" readonly="true" class="small"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col94" label="Borrador" readonly="true" class="small"></vaadin-text-field>
      <div style="width:128px;display: inline-flex;top: -15px;position: relative;font-weight: 500;font-size: 11px;color: #000040;">
       <div style="display: inline-block;width: 50%;line-height: 4px;">
        <span>C. Especial</span>
        <br>
        <vaadin-checkbox id="col99"></vaadin-checkbox>
       </div>
       <div style="display: inline-block;width: 50%;line-height: 4px;">
        <span>Exento Icf</span>
        <br>
        <vaadin-checkbox id="col102"></vaadin-checkbox>
       </div>
      </div>
      <br>
      <vaadin-text-field id="col97" label="Compra" readonly="true" class="small"></vaadin-text-field>
      <vaadin-text-field id="col100" label="Comerc. 2" readonly="true" class="small"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col80" label="Contable" readonly="true" class="small"></vaadin-text-field>
      <vaadin-text-field id="col98" label="Reciclaje" readonly="true" class="small"></vaadin-text-field>
      <br>
      <vaadin-text-field id="col82" label="Mod Trf Man" readonly="true" class="small"></vaadin-text-field>
      <vaadin-text-field id="col103" label="Mod Trf Auto" readonly="true" class="small"></vaadin-text-field>
     </div>
    </fieldset>
    <fieldset style="min-width:330px;">
     <legend>Descuentos</legend>
     <div style="margin: 0 auto;width: 307px;">
      <div style="width:100%;display:flex;">
       <div style="width:140px;display:inline-block;">
        <vaadin-text-field id="col24" class="verySmall" label="Clave"></vaadin-text-field>
        <br>
        <vaadin-text-field id="col95" class="verySmall" label="Borrador"></vaadin-text-field>
       </div>
       <fieldset style="width:157px;display: inline-flex;">
        <legend>Descuentos</legend>
        <vaadin-text-field id="col78" class="verySmall" label="Contable"></vaadin-text-field>&nbsp; 
        <vaadin-text-field id="col83" class="verySmall" label="Comercial"></vaadin-text-field>
       </fieldset>
      </div>
      <div style="width:100%;display:flex;">
       <fieldset style="width:174px;display: inline-block;text-align: left;">
        <legend style="font-size: smaller;">(A)Dtos. (B)Boni. (C)Rap. (D)Incr.</legend> 1&nbsp; 
        <vaadin-text-field id="col85" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col89" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col92" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col123" class="veryVerySmall"></vaadin-text-field>
        <br> 2&nbsp; 
        <vaadin-text-field id="col86" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col90" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col93" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col124" class="veryVerySmall"></vaadin-text-field>
        <br> 3&nbsp; 
        <vaadin-text-field id="col87" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col91" class="veryVerySmall"></vaadin-text-field>
        <br> 4&nbsp; 
        <vaadin-text-field id="col88" class="veryVerySmall"></vaadin-text-field>
       </fieldset>
       <fieldset style="width:115px;display: inline-block;">
        <legend>Patrón</legend>
        <div style="text-align: left;margin-left: 2px;font-size: 16px;">
         <span style="color: white;">A &nbsp; &nbsp;&nbsp; B &nbsp; C &nbsp;D</span>
         <br>
         <span style="color: #000040;">12341231212 </span>
        </div>
        <vaadin-text-field id="col84" style="width:102px;"></vaadin-text-field>
       </fieldset>
      </div>
     </div>
    </fieldset>
    <fieldset style="min-width: 196px;">
     <legend>Precios</legend>
     <div>
      <vaadin-text-field id="col58" class="small" label="Intercambio"></vaadin-text-field>
      <vaadin-text-field id="col55" class="veryVerySmall" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col53" class="small" label="Mayor Neto"></vaadin-text-field>
      <vaadin-text-field id="col56" class="veryVerySmall" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col52" class="small" label="PVP"></vaadin-text-field>
      <vaadin-text-field id="col57" class="veryVerySmall" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col76" class="small" label="Prec. corte"></vaadin-text-field>
      <span style="width:32px;display: inline-block;"></span>
      <br>
      <vaadin-text-field id="col36" class="veryVerySmall" label="Clave"></vaadin-text-field>
      <vaadin-button theme="icon small" aria-label="Add new" style="margin-right:20px; padding:0;">
       <iron-icon icon="lumo:plus"></iron-icon>
      </vaadin-button>
      <vaadin-text-field id="col60" class="veryVerySmall" label="Borrador"></vaadin-text-field>
      <vaadin-button theme="icon small" aria-label="Add new">
       <iron-icon icon="lumo:plus"></iron-icon>
      </vaadin-button>
     </div>
    </fieldset>
    <fieldset style="min-width: 218px;">
     <legend>Precios Tienda</legend>
     <div>
      <vaadin-text-field id="col63" class="small" label="Mínimo"></vaadin-text-field>
      <vaadin-text-field id="col61" class="veryVerySmall" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col64" class="small" label="Interc."></vaadin-text-field>
      <vaadin-text-field id="col62" class="veryVerySmall" label=" "></vaadin-text-field>
      <br>
      <vaadin-text-field id="col74" class="small" label="Objetivo"></vaadin-text-field>
      <vaadin-text-field id="col75" class="veryVerySmall" label=" "></vaadin-text-field>
      <br>
      <fieldset style="min-width: 196px;">
       <legend>PVP</legend>
       <div>
        <span style="color:red;">Gal</span>
        <vaadin-text-field id="col67" class="verySmall"></vaadin-text-field>
        <vaadin-text-field id="col66" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field id="col68" class="veryVerySmall"></vaadin-text-field>
        <br>
        <span style="color:red;">Hos</span>
        <vaadin-text-field id="col72" class="verySmall"></vaadin-text-field>
        <vaadin-text-field id="col71" class="veryVerySmall"></vaadin-text-field>
        <vaadin-text-field class="veryVerySmall"></vaadin-text-field>
       </div>
      </fieldset>
      <vaadin-button>
        + detalle 
      </vaadin-button>
     </div>
    </fieldset>
   </div>
  </page>
  <page>
   <div style="width:100%; display:inline-flex;">
    <fieldset>
     <div style="text-align: left;margin: 0 auto;width: 406px;">
      <div>
       <vaadin-text-field id="col10" class="small" label="Ref. Proveedor"></vaadin-text-field>
       <vaadin-text-field id="col21" class="small" label="EAN 13"></vaadin-text-field>
       <vaadin-button theme="icon" aria-label="Add new">
        <iron-icon icon="lumo:plus"></iron-icon>
       </vaadin-button>
       <vaadin-text-field id="col20" class="veryVerySmall" label="Clase"></vaadin-text-field>
       <vaadin-text-field id="col105" class="veryVerySmall" label="IVA"></vaadin-text-field>
       <vaadin-text-field id="col27" class="veryVerySmall" label="Dest."></vaadin-text-field>
      </div>
      <div>
       <vaadin-text-field id="col110" class="small" label="Info Tarifa"></vaadin-text-field>
       <vaadin-text-field id="col108" class="veryVerySmall" label="UCA"></vaadin-text-field>
       <vaadin-text-field id="col109" class="veryVerySmall3" label="UxUCA"></vaadin-text-field>
       <vaadin-text-field id="col122" class="veryVerySmall" label="ULC"></vaadin-text-field>
       <vaadin-text-field id="col114" class="veryVerySmall3" label="UxULC"></vaadin-text-field>
       <vaadin-text-field id="col106" class="veryVerySmall" label="UVA"></vaadin-text-field>
       <vaadin-text-field id="col107" class="veryVerySmall3" label="UxUVA"></vaadin-text-field>
      </div>
      <div>
       <vaadin-text-field id="col7" class="veryVerySmall3" label="Prov"></vaadin-text-field>
       <vaadin-text-field id="col120" class="verySmall" label="Cta.P.Tar"></vaadin-text-field>
       <vaadin-button style="margin-right:20px;">
         Prov 
       </vaadin-button>
       <vaadin-text-field id="col121" class="verySmall" label="Comprador"></vaadin-text-field>
       <vaadin-text-field id="col104" class="verySmall" label="Peso Teóric"></vaadin-text-field>
       <vaadin-text-field id="col37" class="veryVerySmall3" label="Estac."></vaadin-text-field>
      </div>
      <div>
       <vaadin-text-field id="col115" class="veryVerySmall3" label="Largo"></vaadin-text-field>
       <vaadin-text-field id="col116" class="veryVerySmall3" label="Ancho"></vaadin-text-field>
       <vaadin-text-field id="col77" class="small" label="Cód.Intrastat"></vaadin-text-field>
       <vaadin-combo-box id="col119" label="Zona Almacén" style="width: 100px;"></vaadin-combo-box>
      </div>
     </div>
    </fieldset>
    <fieldset>
     <div style="text-align: left;margin: 0 auto;width: 406px;">
      <div>
       <vaadin-text-field id="col4" class="veryVerySmall" label="Cap"></vaadin-text-field>
       <vaadin-button theme="icon" aria-label="">
        <iron-icon icon="lumo:plus"></iron-icon>
       </vaadin-button>
       <vaadin-text-field id="col5" class="veryVerySmall" label="Gru"></vaadin-text-field>
       <vaadin-button theme="icon" aria-label="">
        <iron-icon icon="lumo:plus"></iron-icon>
       </vaadin-button>
       <vaadin-text-field id="col6" class="veryVerySmall" label="Sub"></vaadin-text-field>
       <vaadin-button theme="icon" aria-label="">
        <iron-icon icon="lumo:plus"></iron-icon>
       </vaadin-button>
       <div style="display: inline-flex;top: -15px;position: relative;font-weight: 500;font-size: 11px;color: #000040;">
        <div style="display: inline-block;line-height: 4px;">
         <span>Web</span>
         <br>
         <vaadin-checkbox id="col59"></vaadin-checkbox>
        </div>
       </div>
       <vaadin-text-field id="col38" class="veryVerySmall" label="Tipo"></vaadin-text-field>
       <vaadin-text-field id="col65" class="veryVerySmall" label="Área"></vaadin-text-field>
      </div>
      <div>
       <vaadin-date-picker id="col54" style="margin-left:0;" label="Fecha Recuento 1"></vaadin-date-picker>
       <vaadin-date-picker id="col73" label="Fecha Recuento 2"></vaadin-date-picker>
       <vaadin-text-field id="col3" class="veryVerySmall3" label="Fab"></vaadin-text-field>
      </div>
      <div>
       <vaadin-combo-box id="col69" style="width:100px" label="Unidad Produc."></vaadin-combo-box>
       <vaadin-text-field id="col70" class="verySmall" label="Cant.Prod."></vaadin-text-field>
       <vaadin-text-field id="col19" class="verySmall5" label="Clave Distrits"></vaadin-text-field>
       <vaadin-text-field id="col23" class="verySmall5" label="Clave ferret"></vaadin-text-field>
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
   <div id="dvEvol" style="width: 100%;">
    <dynamic-grid id="dgEvol"></dynamic-grid>
   </div>
  </page>
  <page style="display: block;">
   <vaadin-text-field id="col111" label="Observaciones 1" style="width: 45%;"></vaadin-text-field>
   <vaadin-text-field id="col112" label="Observaciones 2" style="width: 45%;"></vaadin-text-field>
   <br>
   <vaadin-text-field id="col113" label="Observaciones 3" style="width: 45%;"></vaadin-text-field>
   <vaadin-text-field id="col118" label="Aviso Presupuesto y Pedido" style="width: 45%;"></vaadin-text-field>
  </page>
  <page>
   <div id="dvAlter" style="width: 100%;">
    <dynamic-grid id="dgAlter"></dynamic-grid>
   </div>
  </page>
  <page>
    <div id="dvTarif" style="width: 100%;">
	   <div style="width: 49%;display: inline-block;">
	    <dynamic-grid id="dgTarif1"></dynamic-grid>
	   </div>
	   <div style="width: 49%;display: inline-block;">
	    <dynamic-grid id="dgTarif2"></dynamic-grid>
	   </div>
   </div>
  </page>
  <page>
   <div id="dvOferta" style="width: 100%;">
	   <div style="width: 49%;display: inline-block;">
	    <dynamic-grid id="dgOferta1"></dynamic-grid>
	   </div>
	   <div style="width: 49%;display: inline-block;">
	    <dynamic-grid id="dgOferta2"></dynamic-grid>
	   </div>
   </div>
  </page>
  <page>
   <div id="dvOfProv" style="width: 100%;">
    <dynamic-grid id="dgOfProv"></dynamic-grid>
   </div>
  </page>
  <page>
   <div id="dvConsProv" style="width: 100%;">
    <dynamic-grid id="dgConsProv"></dynamic-grid>
   </div>
  </page>
  <page>
   <div id="dvColec" style="width: 100%;">
    <dynamic-grid id="dgColec"></dynamic-grid>
   </div>
  </page>
  <page>
   <div id="dvTrans" style="width: 100%;">
	   <div style="width: 49%;display: inline-block;">
	    <dynamic-grid id="dgTrans1"></dynamic-grid>
	   </div>
	   <div style="width: 49%;display: inline-block;">
	    <dynamic-grid id="dgTrans2"></dynamic-grid>
	   </div>
   </div>
  </page>
  <page>
   <div id="dvFicha" style="width: 100%;">
    <dynamic-grid id="dgFicha"></dynamic-grid>
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
