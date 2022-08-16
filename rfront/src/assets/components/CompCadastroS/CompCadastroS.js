import React, {Component} from 'react';
import './CompCadastroS.css';
import TextField from '@mui/material/TextField';

class InputFields extends Component
{
    render()
    {
        return (
            <TextField
                required
                id={this.props.id}
                label={this.props.label}
                placeholder={this.props.placeholder}
                type={this.props.type}
            />
        );
    }
}

class CompCadastroS extends Component
{
    render()
    {
        return (
            <div className='CompCadastroS' class="col-sm-6">
                <form method='POST' action=''>
                    <InputFields label="Nome:" 
                                 id="name" 
                                 name="username" 
                                 placeholder="Coloque o Nome aqui" 
                                 type="text"
                    />
                </form>
            </div>
        );
    }
}
export default CompCadastroS;