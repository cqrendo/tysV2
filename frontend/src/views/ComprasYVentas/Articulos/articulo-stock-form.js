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

class ArticuloStockForm extends PolymerElement {
  static get template() {
    return html`
<style>
      :host {
/*         height: 100%; */
        width: 100%;
    	display:flex;
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
<fieldset style="display:inline-block;">
 <legend>Entradas</legend>
 <div style="width:200px;">
  <vaadin-text-field id="col0" class="verySmall6" label="Propuestas" readonly></vaadin-text-field>
  <vaadin-text-field id="col1" class="verySmall6" label="Pedidas" readonly></vaadin-text-field>
  <vaadin-text-field id="col2" class="verySmall6" label="Pdtes. Recibir" readonly></vaadin-text-field>
  <vaadin-text-field id="col3" class="verySmall6" label="Traslado" readonly></vaadin-text-field>
 </div>
</fieldset>
<fieldset style="display:inline-block;">
 <legend>Salidas</legend>
 <div style="width:200px;">
  <vaadin-text-field id="col4" class="verySmall6" label="Pdtes. Servir" readonly></vaadin-text-field>
  <vaadin-text-field id="col5" class="verySmall6" label="Pedidas Cliente" readonly></vaadin-text-field>
  <vaadin-text-field id="col6" class="verySmall6" label="Traslado" readonly></vaadin-text-field>
 </div>
</fieldset>
<fieldset style="display:inline-block;">
 <legend>Stock</legend>
 <div style="width:200px;">
  <vaadin-text-field id="col7" class="verySmall6" label="Iniciales" readonly></vaadin-text-field>
  <vaadin-text-field id="col8" class="verySmall6" label="Stock Actual" readonly></vaadin-text-field>
  <vaadin-text-field id="col9" class="verySmall6" label="Mínimo" readonly></vaadin-text-field>
  <vaadin-text-field id="col10" class="verySmall6" label="VM" readonly></vaadin-text-field>
  <vaadin-text-field id="col11" class="verySmall6" label="Pedir" readonly></vaadin-text-field>
 </div>
</fieldset>
`;
  }

  static get is() {
    return 'articulo-stock-form';
  }
  
    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ArticuloStockForm.is, ArticuloStockForm);