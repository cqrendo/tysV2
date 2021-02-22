import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '../../admin/products/dynamic-view-grid.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

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
      vaadin-text-field.verySmall{
            width: var(--vaadin-text-field-default-width, 4em);  
/*  				width : 4em;  */
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
					max-width:50%;
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
<vaadin-board>
 <vaadin-board-row>
  <div class="cel" id="cell1">
   <vaadin-tabs selected="{{page1}}">
    <vaadin-tab>
      Stock 
    </vaadin-tab>
    <vaadin-tab>
      Valor Ini 
    </vaadin-tab>
    <vaadin-tab>
      Costes 
    </vaadin-tab>
    <vaadin-tab>
      Dtos. 
    </vaadin-tab>
    <vaadin-tab>
      + Datos 
    </vaadin-tab>
    <vaadin-tab>
      Evol. diaria 
    </vaadin-tab>
    <vaadin-tab>
      Var 
    </vaadin-tab>
   </vaadin-tabs>
   <iron-pages selected="[[page1]]">
    <page>
     <div style="width:100%; display:inline-flex;">
      <fieldset style="width:49%;">
       <legend>Salidas</legend>
       <div id="divpage111">
        <vaadin-text-field id="col43" label="Pedidas" readonly="true"></vaadin-text-field>
        <vaadin-text-field id="col15" label="Pdtes. servir" readonly="true" disabled></vaadin-text-field>
        <vaadin-text-field id="col50" label="Venta Media" readonly="true"></vaadin-text-field>
       </div>
      </fieldset>
      <fieldset style="width:49%;">
       <legend>Stock</legend>
       <div id="divpage112">
        <vaadin-text-field id="col42" label="Iniciales" readonly="true"></vaadin-text-field>
        <vaadin-text-field id="col13" label="Stock" readonly="true"></vaadin-text-field>
        <vaadin-text-field id="col44" label="Máximo" readonly="true"></vaadin-text-field>
       </div>
      </fieldset>
     </div>
    </page>
    <page>
     <fieldset>
      <legend>Iniciales</legend>
      <div id="divpage12">
       <vaadin-text-field id="col125" label="Cantidad" readonly="true"></vaadin-text-field>
       <vaadin-text-field id="col47" label="Valor CM" readonly="true"></vaadin-text-field>
       <br>
       <vaadin-text-field id="col45" label="Coste Medio" readonly="true"></vaadin-text-field>
       <vaadin-text-field id="col46" label="CUE" readonly="true"></vaadin-text-field>
      </div>
     </fieldset>
    </page>
    <page>
     <fieldset>
      <legend>Costes</legend>
      <div id="divpage13">
       <vaadin-text-field id="col79" label="Tarifa" readonly="true"></vaadin-text-field>
       <vaadin-text-field id="col81" label="Comercial" readonly="true"></vaadin-text-field>
       <br>
       <vaadin-text-field id="col94" label="Borrador" readonly="true"></vaadin-text-field>
       <div style="width:192px;display: inline-block;">
        <div style="display: inline-block;width: 50%;position: relative;top: -6px;line-height: 4px;">
         <span style="color: #000040; font-size: 11px;">C. Especial</span>
         <br>
         <vaadin-checkbox id="col99"></vaadin-checkbox>
        </div>
        <label style="color: #000040 !important;
			font-size: 11px !important;
			position: relative;
			top: 7px;
			margin-left: 16px;">Exento Icf</label>
        <vaadin-checkbox id="col102"></vaadin-checkbox>
       </div>
       <br>
       <vaadin-text-field id="col97" label="Compra" readonly="true"></vaadin-text-field>
       <vaadin-text-field id="col100" label="Comerc. 2" readonly="true"></vaadin-text-field>
       <br>
       <vaadin-text-field id="col80" label="Contable" readonly="true"></vaadin-text-field>
       <vaadin-text-field id="col98" label="Reciclaje" readonly="true"></vaadin-text-field>
       <br>
       <vaadin-text-field id="col82" label="Mod Trf Man" readonly="true"></vaadin-text-field>
       <vaadin-text-field id="col103" label="Mod Trf Auto" readonly="true"></vaadin-text-field>
      </div>
     </fieldset>
    </page>
    <page></page>
    <page>
     <fieldset>
      <div id="divpage15"></div>
     </fieldset>
    </page>
    <page>
     <div id="divpage25"></div>
    </page>
    <page>
     <vaadin-tabs selected="{{page3}}" style="width:100%;">
      <vaadin-tab>
        Observaciones 
      </vaadin-tab>
      <vaadin-tab>
        Aviso 
      </vaadin-tab>
     </vaadin-tabs>
     <iron-pages selected="[[page3]]" style="width: 100%;">
      <page>
       <fieldset>
        <div id="divpage31"></div>
       </fieldset>
      </page>
      <page>
       <fieldset>
        <div id="divpage32"></div>
       </fieldset>
      </page>
     </iron-pages>
    </page>
   </iron-pages>
  </div>
  <div class="cel" id="cell2">
   <vaadin-tabs selected="{{page2}}">
    <vaadin-tab>
      Ent. 
    </vaadin-tab>
    <vaadin-tab>
      Val Act 
    </vaadin-tab>
    <vaadin-tab>
      Precios 
    </vaadin-tab>
    <vaadin-tab>
      Pt 
    </vaadin-tab>
    <vaadin-tab>
      Datos 
    </vaadin-tab>
    <vaadin-tab>
      Alter 
    </vaadin-tab>
   </vaadin-tabs>
   <iron-pages selected="[[page2]]">
    <page>
     <fieldset>
      <legend>Entradas</legend>
      <div id="divpage21">
       <vaadin-text-field id="col40" label="Propuestas" readonly="true"></vaadin-text-field>
       <vaadin-text-field id="col16" label="Cantidad Neta a Pedir" readonly="true" disabled></vaadin-text-field>
       <br>
       <vaadin-text-field id="col41" label="Pedidas" readonly="true"></vaadin-text-field>
       <vaadin-combo-box id="col117" label="Plazo Entrega"></vaadin-combo-box>
       <br>
       <vaadin-text-field id="col14" label="Pdtes. Recibir" readonly="true" disabled></vaadin-text-field>
       <vaadin-text-field id="col51" label="Int. Pedido" readonly="true"></vaadin-text-field>
      </div>
     </fieldset>
    </page>
    <page>
     <fieldset>
      <legend>Actual</legend>
      <div id="divpage22"></div>
     </fieldset>
    </page>
    <page>
     <fieldset>
      <legend>Precios</legend>
      <div id="divpage23"></div>
     </fieldset>
    </page>
    <page>
     <fieldset>
      <legend>Precios Tienda</legend>
      <div id="divpage24"></div>
     </fieldset>
    </page>
    <page>
     <vaadin-tabs selected="{{page4}}" style="width:100%;">
      <vaadin-tab>
        1 
      </vaadin-tab>
      <vaadin-tab>
        2 
      </vaadin-tab>
      <vaadin-tab>
        Alta 
      </vaadin-tab>
     </vaadin-tabs>
     <iron-pages selected="[[page4]]" style="width: 100%;">
      <page>
       <fieldset>
        <div id="divpage41"></div>
       </fieldset>
      </page>
      <page>
       <fieldset>
        <div id="divpage42"></div>
       </fieldset>
      </page>
      <page>
       <fieldset>
        <div id="divpage43"></div>
       </fieldset>
      </page>
     </iron-pages>
    </page>
    <page>
     <div id="divpage25"></div>
    </page>
   </iron-pages>
  </div>
 </vaadin-board-row>
</vaadin-board>
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
