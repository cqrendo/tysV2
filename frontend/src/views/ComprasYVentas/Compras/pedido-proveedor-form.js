import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '../../../components/form-buttons-bar.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '../../generic/crud-view.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '../../../components/buttons-bar.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-dialog/src/vaadin-dialog.js';
import '../../generic/layout/dynamic-grid-for-pick.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import '@vaadin/vaadin-text-field/src/vaadin-integer-field.js';
import '@polymer/iron-pages/iron-pages.js';

class PedidoProveedorForm extends PolymerElement {
  static get template() {
    return html`
<style>
      :host {
/*         height: 100%; */
        width: 100%;
/*         margin: 5px; */
        
      }

       vaadin-form-layout { 
       
        overflow: auto; 
       } 
      :host(.custom-style) [part="input-field"] {
        border: 10px solid #ccc;
        background-color: #bbb;
      }
       :host([focused].custom-style) [part="input-field"] {
        border-color: #aaa;
      }
	    
       vaadin-form-item { 
       
    	flex: auto ;
	    overflow: auto; 
 	    --vaadin-form-item-label-width: 1em; 
        --vaadin-form-item-label-spacing: 1em;
        --vaadin-form-item-row-spacing: 1.25em; 
 	    }  
    
          
      .veryBig{
                width: var(--vaadin-text-field-default-width, 28em);
                margin-left: 5px;
      }
      
      .big{
                width: var(--vaadin-text-field-default-width, 20em);
                margin-left: 5px;
      }
      .medium{
                width: var(--vaadin-text-field-default-width, 10em);
                margin-left: 5px;
            }
      .verySmall{
            width: var(--vaadin-text-field-default-width, 4em);  
/*  				width : 4em;  */
 				margin-left: 5px;
             }  
      .small{
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
    </style>
<h3 id="title" style="height:0px"></h3>
<vaadin-tabs selected="{{page}}">
 <vaadin-tab selected>
   Pedido 
 </vaadin-tab>
 <vaadin-tab>
   Entrega Directa 
 </vaadin-tab>
</vaadin-tabs>
<iron-pages selected="[[page]]">
 <page>
  <vaadin-form-layout id="form"></vaadin-form-layout>
  <div class="linCampos">
   <vaadin-integer-field id="col0" label="Num " maxlength="2" class="verySmall"></vaadin-integer-field>
   <vaadin-integer-field id="col1" label=" " maxlength="2" class="small"></vaadin-integer-field>
   <vaadin-date-picker id="col2" label="Fecha"></vaadin-date-picker>
   <vaadin-integer-field id="col3" label="Prov." class="verySmall"></vaadin-integer-field>
   <vaadin-text-field id="col4" label="Nombre Proveedor" class="big" readonly="true"></vaadin-text-field>
   <vaadin-text-field id="col27" label="P. Pago" class="verySmall"></vaadin-text-field>
   <vaadin-integer-field id="col28" label="Fase" class="verySmall"></vaadin-integer-field>
   <vaadin-text-field id="col5" label="Rappel" class="verySmall"></vaadin-text-field>
   <vaadin-integer-field id="col7" class="verySmall" label="Comprador"></vaadin-integer-field>
   <vaadin-text-field id="col8" label="Nombre Comprador" readonly="true"></vaadin-text-field>
  </div>
  <div class="lastColumn">
   <vaadin-text-area id="col26" label="Lugar de Entrega" style="height:180px;width:264px "></vaadin-text-area>
  </div>
  <div class="linCampos">
   <vaadin-text-field id="col9" label="Atencion De " maxlength="2" class="medium" style="width:12.7em"></vaadin-text-field>
   <vaadin-date-picker id="col10" label="Plazo Entrega"></vaadin-date-picker>
   <vaadin-text-area id="col11" label="Texto Libre" style="width:32.5em;height:39px"></vaadin-text-area>
   <vaadin-combo-box id="col12" class="small" label="Portes"></vaadin-combo-box>
  </div>
  <div class="linCampos">
   <vaadin-integer-field id="col6" label="Ag.T." maxlength="2" class="verySmall"></vaadin-integer-field>
   <vaadin-text-field id="col13" label="Transportista" readonly="true"></vaadin-text-field>
   <vaadin-text-field id="col14" class="verySmall" label="F pago "></vaadin-text-field>
   <vaadin-text-field id="col15" label=" "></vaadin-text-field>
   <vaadin-text-field id="col16" class="big" label="Condiciones especiales de pago"></vaadin-text-field>
  </div>
  <div class="linCampos">
   <vaadin-text-field id="col17" class="verySmall" label="FPN"></vaadin-text-field>
   <vaadin-text-field id="col18" label="Forma Pago Negociada"></vaadin-text-field>
   <vaadin-text-field id="col19" class="big" label="Aviso para dpto Provedores (tys)"></vaadin-text-field>
   <vaadin-integer-field id="col20" label="Num Ped Cliente"></vaadin-integer-field>
   <vaadin-checkbox id="col31">
     Entrega Directa 
   </vaadin-checkbox>
  </div>
  <div class="lastColumn">
   <vaadin-text-field id="col25" label="Total" class="Small"></vaadin-text-field>
  </div>
  <div class="linCampos">
   <vaadin-text-field id="col21" label="Suma Peso" class="verySmall"></vaadin-text-field>
   <vaadin-integer-field id="col22" class="verySmall" label="Para Cliente" clear-button-visible></vaadin-integer-field>
   <vaadin-text-field id="col23" label="Nombre Cliente" class="big"></vaadin-text-field>
   <vaadin-text-field id="col24" label="Num Pedido Del Prov" class="Small"></vaadin-text-field>
   <br>
   <vaadin-button id="b1" label="">
     ver Entrada 
   </vaadin-button>
   <vaadin-button id="b2" label="">
     ver Consulta Prov 
   </vaadin-button>
   <vaadin-button id="b3" class="Small">
     ver NoConformidad 
   </vaadin-button>
   <!--  <vaadin-custom-field id="col25" label="Total" required error-message="Please fill in all fields"> -->
   <!--   <input type="decimal" id="input"> -->
   <!--   <select><option>Euro</option><option>Dollars</option><option>Pounds</option></select> -->
   <!--  </vaadin-custom-field> -->
  </div>
 </page>
 <page>
  <div class="linCampos">
   <vaadin-text-field id="col32" label="ED Nombre" class="big"></vaadin-text-field>
   <vaadin-text-field id="col33" label="ED Atencion de" class="big"></vaadin-text-field>
  </div>
  <div class="linCampos">
   <vaadin-text-field id="col34" label="ED Domicilio" class="big"></vaadin-text-field>
  </div>
  <div class="linCampos">
   <vaadin-text-field id="col35" label="ED CodPostal"></vaadin-text-field>
   <vaadin-text-field id="col36" label="ED Localidad"></vaadin-text-field>
  </div>
  <div class="linCampos">
   <vaadin-text-field id="col37" label="ED Provincia" class="big"></vaadin-text-field>
   <vaadin-text-field id="col38" label="ED Pais" class="big"></vaadin-text-field>
  </div>
  <div class="linCampos">
   <vaadin-text-field id="col39" label="ED Aviso" class="big"></vaadin-text-field>
  </div>
 </page>
</iron-pages>
<vaadin-dialog id="dialogForPick"></vaadin-dialog>
`;
  }

  static get is() {
    return 'pedido-proveedor-form';
  }
  ready() {
    super.ready();
    this.$.form.addEventListener('change', e => {
      this.$.buttons.$.save.disabled = false;
    });
  }
}
window.customElements.define(PedidoProveedorForm.is, PedidoProveedorForm);
function openTab(evt, tabName)
{var i, tabcontent, tablinks;tabcontent = document.getElementsByClassName("tabcontent");
for (i = 0; i < tabcontent.length; i++) 
{tabcontent[i].style.display = "none";}
tablinks = document.getElementsByClassName("tablinks");
for (i = 0; i < tablinks.length; i++) 
{tablinks[i].className = tablinks[i].className.replace(" active", "");}
document.getElementById(tabName).style.display = "block";evt.currentTarget.className += " active";}

